package com.cacheserverdeploy.deploy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Deploy
{
    //初始化图状态变量
    private static int netNodeNumber; //网络节点总数(不可改变)
    private static int netLinkNumber; //网络链路总数(不可改变)
    private static int consumerNodeNumber; //消费节点总数(不可改变)

    private static int serverCost; //服务器部署成本

    private static int[][] graph = null; //图中网络节点之间的可达性及代价:起始节点->终止节点 (不可改变)
    private static int[][] linkWidth = null; //图中网络节点之间的链路及其带宽(不可改变)

    private static int[] consumerIdNeedWidth;//消费节点及其需要的带宽 index:消费节点编号 value:带宽需求(不可改变)
    private static int[] consumerIdLinkId;//消费节点连接的网络节点 index:消费节点编号 value:网络节点编号(不可改变)

    //private static int col, row;


    // 网络路径信息,从消费节点的编号大小开始统计0~N,对应netLinkRoadWidth的路径带宽
    //存储每个消费节点到所有服务器的所有路径 index:消费节点编号 value:消费节点到服务器的所有路径信息
    private static ArrayList<ArrayList>[] allNetLinkRoad;
    //存储没个消费节点到供给它流量的服务器的路径信息 index:消费节点编号 value:消费节点到服务器的信息
    private static ArrayList<ArrayList>[] usefulNetLindPath;
    //存储每个消费节点到供它流量的服务器的路径带宽 index:消费节点编号 每个数组内部index:该消费节点的第几条路径 value:该路径可供的带宽量
    private static  ArrayList<Integer>[] usefulNetLinkPathWidth;// 存储临时有用路径的所有带宽

    //服务器节点编号
    private static ArrayList<Integer> serverNodes = null;
    private static ArrayList<Integer> servers= null;

    // 初始化图
    private static void init(String[] graphContent) {
        int cur = 0;//行标
        String[] content = graphContent[cur++].split(" ");

        //初始化网络节点总数、网络链路总数、消费节点总数
        netNodeNumber = Integer.parseInt(content[0]);
        netLinkNumber = Integer.parseInt(content[1]);
        consumerNodeNumber = Integer.parseInt(content[2]);

        cur++;//空行

        //初始化服务器节点花费
        content = graphContent[cur++].split(" ");
        serverCost = Integer.parseInt(content[0]);

        cur++;//空行

        //初始化图
        graph = new int[netNodeNumber][netNodeNumber];
        linkWidth = new int[netNodeNumber][netNodeNumber];
        for (int i = 0; i < netLinkNumber; i++) {
            content = graphContent[cur++].split(" ");
            int row = Integer.parseInt(content[0]);
            int col = Integer.parseInt(content[1]);
            graph[row][col] = Integer.parseInt(content[3]);//网络节点之间的可达性及其花费
            graph[col][row] = graph[row][col];
            linkWidth[row][col] = Integer.parseInt(content[2]);//网络节点之间的可达性及其带宽大小
            linkWidth[col][row] = linkWidth[row][col];
        }
        cur++;//空行

        //初始化消费节点
        consumerIdNeedWidth = new int[consumerNodeNumber];
        consumerIdLinkId = new int[consumerNodeNumber];
        for (int i = 0; i < consumerNodeNumber; i++) {
            content = graphContent[cur++].split(" ");
            int consumerId = Integer.parseInt(content[0]);
            consumerIdNeedWidth[consumerId] = Integer.parseInt(content[2]);//消费节点需要的带宽
            consumerIdLinkId[consumerId] = Integer.parseInt(content[1]);//消费节点连接的网络节点
            //初始化与消费节点连接的网络节点自己到自己的带宽
            linkWidth[consumerIdLinkId[consumerId]][consumerIdLinkId[consumerId]] = consumerIdNeedWidth[consumerId];
        }

        //初始化服务器节点编号
        serverNodes = new ArrayList<Integer>();//使用前需要初始化
        servers = new ArrayList<Integer>();
        for (int i = 0; i < consumerNodeNumber; i++) {
            serverNodes.add(consumerIdLinkId[i]);
            servers.add(consumerIdLinkId[i]);
        }
        //初始化有用的链路信息
        usefulNetLindPath = new ArrayList[consumerNodeNumber];
        for(int i = 0; i < consumerNodeNumber; i++) {
            ArrayList<Integer> linkRoad = new ArrayList<Integer>();
            linkRoad.add(consumerIdLinkId[i]);
            usefulNetLindPath[i] = new ArrayList<ArrayList>();//初始化
            usefulNetLindPath[i].add(linkRoad);
        }

        //初始化链路信息
        allNetLinkRoad = new ArrayList[consumerNodeNumber];

        //初始化有用的路径的带宽
        tmpUsefulNetLinkPathWidth = new ArrayList[consumerNodeNumber];
        usefulNetLinkPathWidth = new ArrayList[consumerNodeNumber];
    }

    //找出source节点到dest节点的所有路径 source: 消费节点邻接的网络节点 dest:服务器节点
    private static void findTheAllPath(int[][] graphInfo, int source, int dest) {
        int consumerNodeNum = get_consumerId(source);
        allNetLinkRoad[consumerNodeNum] = new ArrayList<ArrayList>();
        boolean[] isVisited = new boolean[netNodeNumber];
        ArrayList<Integer> path = new ArrayList<Integer>();

        if(source == dest) return;

        path.add(source);//将源点加进去
        isVisited[source] = true;

        int top_node;
        int pop_node = -1;//最开始pop_node从0开始遍历

        while(!path.isEmpty()) {
            //System.out.println("here");
            int index = path.size() - 1;
            top_node = path.get(index);//得到最后一个元素
            int k;
            for(k = pop_node + 1; k < netNodeNumber; k++) {
                if(graphInfo[top_node][k] != 0 && isVisited[k] == false) {
                    //如果当前节点是目的节点,则压栈,并且将该条路径放到所有路径信息中
                    //System.out.println(k  + " " + dest);
                    if(k == dest) {
                        path.add(k);
                        //打印测试路径的正确性
                        //System.out.print("here");
                        //System.out.println(path);
                        ArrayList<Integer> tmpPath = new ArrayList<Integer>(path);
                        allNetLinkRoad[consumerNodeNum].add(tmpPath);
                        //System.out.println(tmpPath);
                        //pop_node = path.get(path.size() - 1);
                        index = path.size() - 1;
                        path.remove(index);
                        //break;
                    } else {
                        //System.out.println("here");
                        pop_node = -1;//注意每次pop之后有新的节点进栈,需要将pop_node归零
                        isVisited[k] = true;
                        path.add(k);
                        break;
                    }
                    //System.out.println("here");
                }
            }
            //如果所有的邻接节点都被访问了
            if(k == netNodeNumber) {
                index = path.size() - 1;
                pop_node = path.get(index);
                //将之前所有的邻接节点置为为访问,c必须从pop_node开始,否则会出现环
                for(int c = 0; c < netNodeNumber; c++) {
                    //注意避免出现访问环,需要判断邻接点是否包含起始点
                    //System.out.println("here");
                    if(graphInfo[pop_node][c] != 0 && (c != source) && !path.contains(c))
                        isVisited[c] = false;
                }
                index = path.size() - 1;
                path.remove(index);
            }
        }
        //System.out.println("here");
    }

    //计算消费节点邻接的网络节点到服务器节点的所有路径
    private static void calculateAllThePath() {
        for (int i = 0; i < consumerNodeNumber; i++) {
            int source = consumerIdLinkId[i];//消费节点邻接的网络节点id
            int size = serverNodes.size();
            for (int j = 0; j < size; j++) {
                int dest = serverNodes.get(j);//服务器节点
                //System.out.println("here");
                findTheAllPath(graph, source, dest);//找出source与dest之间所有路径
            }
            //System.out.println("here");
        }
        //最后再加上服务器节点设在消费节点邻接节点的那个位置上的路径,即为邻接节点本身
        for(int i = 0; i < consumerNodeNumber; i++) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            if (serverNodes.contains(consumerIdLinkId[i])) {
                path.add(consumerIdLinkId[i]);
                ArrayList<Integer> tmp = new ArrayList<Integer>(path);
                allNetLinkRoad[i].add(tmp);
            }
        }
    }

    //找出路径中包含的服务器节点
    private static HashSet<Integer> findTheServerNodes(ArrayList<ArrayList>[] paths) {
        HashSet<Integer> server = new HashSet<Integer>();
        ArrayList<Integer> path;
        for(int i = 0; i < consumerNodeNumber; i++) {
            for(int j = 0; j < paths[i].size(); j++) {
                path = paths[i].get(j);
                int node = path.get(path.size() - 1);
                server.add(node);
            }
        }
        return server;
    }

    //更新服务器节点
    private static void updateTheServerNodes() {
        int serverNum = servers.size();//获得当前服务器的个数
        HashSet<Integer> tmpServer = new HashSet<Integer>();
        Random ran = new Random();
        //随机获得服务器节点
        while(tmpServer.size() < serverNum) {
            int s = ran.nextInt(netNodeNumber);
            tmpServer.add(s);
        }
        serverNodes = new ArrayList<Integer>(tmpServer);
        //测试
        //System.out.println(serverNodes);
    }

    //计算当前状态的成本
    private static int calculateTheCost() {
        int cost;
        int theServerCost = serverCost * serverNodes.size();//服务器成本
        int theWidthCost = 0;//带宽成本
        for(int i = 0; i < consumerNodeNumber; i++) {
            ArrayList<ArrayList> paths = usefulNetLindPath[i];
            int pathsCount = paths.size();// 第i个消费节点的路径总数
            for(int j = 0; j < pathsCount; j++) {
                ArrayList<Integer> path = paths.get(j);//获得第i个消费节点的第j条路径
                int size = path.size();
                if(size == 1)
                    continue;//若是该路径是消费节点邻接的网络节点组成的路径,则不用计算带宽费用
                int pathIndex0, pathIndex1;
                for(int k = 1; k < size; k++) {
                    pathIndex0 = path.get(k - 1);
                    pathIndex1 = path.get(k);
                    theWidthCost += graph[pathIndex0][pathIndex1] * usefulNetLinkPathWidth[i].get(j);
                }
            }
        }
        cost = theServerCost + theWidthCost;
        return cost;
    }

    //更新优化后的结果
    private static void updateTheState(ArrayList<ArrayList>[] usefulPath) {
        HashSet<Integer> tmpServerNodes = findTheServerNodes(usefulPath);//找出所有路径中包含的服务器节点
        // 更新服务器节点
        //serverNodes = new ArrayList<Integer>(tmpServerNodes);
        servers = new ArrayList<Integer>(tmpServerNodes);//
        // 更新有用路径
        usefulNetLindPath = new ArrayList[consumerNodeNumber];
        for(int i = 0; i < consumerNodeNumber; i++) {
            ArrayList<ArrayList> path = new ArrayList<ArrayList>(usefulPath[i]);
            usefulNetLindPath[i] = new ArrayList<ArrayList>(path);//初始化
        }
        //更新有用路径带宽
        for(int i = 0; i < consumerNodeNumber; i++) {
            usefulNetLinkPathWidth[i] = new ArrayList<Integer>(tmpUsefulNetLinkPathWidth[i]);
        }
    }

    // 计算所有消费节点的邻接网络节点到服务器节点的所有路径
    private static void run() {
        int theAllCost = consumerNodeNumber * serverCost;//初始状态所有成本
        ArrayList<ArrayList>[] usefulPath;
        int iterate = 0;
        //迭代开始
        while(true) {
            calculateAllThePath();//计算消费节点邻接的网络节点到服务器节点的所有路径
            usefulPath = findTheUsefulPath();//在找出的所有路径中找出有用的路径
            if(usefulPath != null) {//找到了有用路径
                //找出的服务器节点个数比之前的要小,则将serverNodes更新为最新
                int serverCount = findTheServerNodes(usefulPath).size();
                if (serverCount < servers.size()) {
                    //更新一下优化后的状态
                    updateTheState(usefulPath);
                    //更新成本
                    theAllCost = calculateTheCost();
                } else {
                    int cost = calculateTheCost();
                    if (cost < theAllCost) {
                        updateTheState(usefulPath);//更新状态
                        theAllCost = cost;
                    }
                }
            }
            //更新服务器节点
            updateTheServerNodes();
            System.out.println(serverNodes);
//            for (int i = 0; i < consumerNodeNumber; i++) {
//                System.out.println(usefulNetLindPath[i] + ":" + usefulNetLinkPathWidth[i]);
//            }
        }
    }

    //找出给出的路径上最小的带宽
    private static int findThemin(ArrayList<Integer> path, int[][] tmpLinkW) {
        int size = path.size();
        int tmp;
        int min = tmpLinkW[path.get(0)][path.get(1)];
        for(int i = 2; i < size; i++) {
            tmp = tmpLinkW[path.get(i-1)][path.get(i)];
            if(tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

    private static ArrayList<Integer>[] tmpUsefulNetLinkPathWidth;// 存储临时有用路径的所有带宽
    //找出所有的有用的路径
    private static ArrayList<ArrayList>[] findTheUsefulPath() {
        ArrayList<ArrayList>[] tmpUsefulNetLinkRoad = new ArrayList[consumerNodeNumber];//临时的有用消费节点路径
        int[][] tmpLinkWidth = new int[netNodeNumber][netNodeNumber];//临时的所有网络路径带宽
        for(int i = 0; i < netNodeNumber; i++) {
            for(int j = 0; j < netNodeNumber; j++) {
                tmpLinkWidth[i][j] = linkWidth[i][j];
            }
        }
        //临时消费节点需要的带宽变量
        int[] tmpConsumerNeedWidth = new int[consumerNodeNumber];
        for(int i = 0; i < consumerNodeNumber; i++) {
            tmpConsumerNeedWidth[i] = consumerIdNeedWidth[i];
        }
        for(int i = 0; i < consumerNodeNumber; i++) {
            int countOfRoad = allNetLinkRoad[i].size();//当前消费节点的邻接节点到各个服务器节点的链路个数
            int tmpWidh = 0;
            tmpUsefulNetLinkRoad[i] = new ArrayList<ArrayList>();
            tmpUsefulNetLinkPathWidth[i] = new ArrayList<Integer>();
            for(int j = 0; (tmpConsumerNeedWidth[i] > 0) && j < countOfRoad; j++) {
                ArrayList<Integer> tmpPath = new ArrayList<Integer>(allNetLinkRoad[i].get(j));//获得一条链路
                if(tmpPath.size() == 1) {
                    //因为有一条消费节点邻接的网络节点的路径就OK了,不在需要其他路径恢复已经添加的临时有用路径的带宽
                    for(int x = 0; x < tmpUsefulNetLinkRoad[i].size(); x++) {
                        ArrayList<Integer> tmpPa = new ArrayList<Integer>(tmpUsefulNetLinkRoad[i].get(x));// 获取第i个消费节点的第x条有用路径
                        int len = tmpPa.size();//获得这条路径的长度
                        int ind0, ind1;
                        for(int y = 1; y < len; y++) {
                            ind0 = tmpPa.get(y-1);
                            ind1 = tmpPa.get(y);
                            tmpLinkWidth[ind0][ind1] += tmpUsefulNetLinkPathWidth[i].get(x);
                        }
                    }
                    tmpUsefulNetLinkRoad[i].clear();//只需要消费节点邻接的节点的路径就OK了,将其他路径清除
                    ArrayList<Integer> tmp = new ArrayList<Integer>(tmpPath);
                    tmpUsefulNetLinkRoad[i].add(tmp);
                    tmpWidh = consumerIdNeedWidth[i];
                    tmpUsefulNetLinkPathWidth[i].clear();
                    tmpUsefulNetLinkPathWidth[i].add(tmpWidh);
                    tmpConsumerNeedWidth[i] = 0;//不在需要带宽了
                    continue;
                }
                int width = findThemin(tmpPath, tmpLinkWidth);//找到该链路上最小带宽
                if(width == 0) continue;
                //System.out.println(tmpPath + ":" + width);
                if(width > tmpConsumerNeedWidth[i]) {
                    width = tmpConsumerNeedWidth[i];//如果该链路上可提供的带宽比需要的带宽大,则修改为需要的带宽
                }
                tmpConsumerNeedWidth[i] -= width;
                tmpWidh += width;
                tmpUsefulNetLinkPathWidth[i].add(width);//将当前路径带宽添加进来
                int len = tmpPath.size();
                int index0, index1;
                for(int k = 1 ; k < len; k++) {
                    index0 = tmpPath.get(k-1);
                    index1 = tmpPath.get(k);
                    tmpLinkWidth[index0][index1] -= width;//将相应路径的带宽减掉
                }
                tmpUsefulNetLinkRoad[i].add(tmpPath);
            }
            if(tmpWidh < consumerIdNeedWidth[i]) {//算出的当前消费节点的所有有用路径提供的带宽不能满足该消费节点的带宽需求
                return null;
            }
            //测试
            //System.out.println(tmpUsefulNetLinkRoad[i] + ":" + tmpWidh + ":" + tmpUsefulNetLinkPathWidth[i]);
        }
        return tmpUsefulNetLinkRoad;
    }

    //获得消费节点ID
    private static int get_consumerId(int value) {
        for(int i = 0; i < consumerIdLinkId.length; i++) {
            if(consumerIdLinkId[i] == value)
                return i;
        }
        return -1;
    }

    //将得到的网络路径信息转化为题目要求的格式
    private static String traslate(int i) {
        String str;
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> lis = null;//netLinkRoad.get(i);
        int len = lis.size();
        for(int k = 0; k < len; k++) {
            sb.append(lis.get(k));
            sb.append(" ");
        }
        int value = lis.get(lis.size() - 1);
        int consumerNode = get_consumerId(value);
        //sb.append(Integer.toString(consumerNode) + " " + Integer.toString((netLinkRoadWidth.get(i))));
        str = sb.toString();
        return str;
    }

    //写入路径信息
    private static String[] writeNetLinkRoad() {
        int len = 0;//usefulNetLindRoad.size();
        String[] sb = new String[len + 2];
        sb[0] = String.valueOf(len);
        sb[1] = "\r";
        for(int i = 0; i < len; i++) {
            sb[i + 2] = traslate(i);
        }
        return sb;
        //return new String[]{"17","\r\n","0 8 0 20"};
    }

    /**
     * 你需要完成的入口
     * <功能详细描述>
     * @param graphContent 用例信息文件
     * @return [参数说明] 输出结果信息
     * @see [类、类#方法、类#成员]
     */
    public static String[] deployServer(String[] graphContent) {
        //初始化图graph[][]
        init(graphContent);

//        for (int i = 0; i < consumerNodeNumber; i++) {
//            int source = consumerIdLinkId[i];
//            for (int j = 0; j < serverNodes.size(); j++) {
//                findTheAllPath(graph, source, serverNodes.get(j));
//            }
//        }
        //run();
        //calculate();
        calculateAllThePath();
        findTheUsefulPath();
//        ArrayList<Integer> path = new ArrayList<Integer>();
//        path.add(8);
//        path.add(0);
//        path.add(1);
//        path.add(2);
//        path.add(21);
//        path.add(22);
//        path.add(23);
//        path.add(24);
//        System.out.println(findThemin(path));
        for(int i = 0; i < allNetLinkRoad.length; i++) {
            System.out.println(allNetLinkRoad[i]);
        }
        //String[] result = writeNetLinkRoad();

        //return result;
        /**do your work here**/
        return new String[]{"17", "\r\n", "0 8 0 20"};

    }
}
