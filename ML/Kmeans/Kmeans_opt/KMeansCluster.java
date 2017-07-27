package ML.Kmeans.Kmeans_opt;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by xwz on 3/2/17.
 */
public class KMeansCluster {

    private int k;//簇的个数
    private int num = 10000000;//迭代次数
    private List<Double> datas;//原始样本集
    private String address;//样本集路径
    private List<Point> data = new ArrayList<Point>();//样本点集
    private AbstractDistance distance = new AbstractDistance() {
        @Override
        public double getDis(Point p1, Point p2) {
            //欧几里德距离
            double dis = 0.0;
            for(int i = 0; i < p1.getX().size(); i++) {
                if(p1.getX().get(i) instanceof String) {
                    dis += p1.getX().get(i).equals(p2.getX().get(i)) ? 0 : 1;
                } else {
                    dis += Math.pow((Double) p1.getX().get(i) - (Double) p2.getX().get(i), 2);
                }
            }
            return Math.sqrt(dis); }
    };

    //构造函数 簇的个数、迭代次数、样本集路径
    public KMeansCluster(int k, int num, String address) {
        this.k = k;
        this.num = num;
        this.address = address;
    }

    //构造函数 簇的个数、样本集路径
    public KMeansCluster(int k, String address) {
        this.k = k;
        this.address = address;
    }

    //构造函数 簇的个数、原始样本集(double型数值)
    public KMeansCluster(int k, List<Double> datas) {
        this.k = k;
        this.datas = datas;
    }

    //构造函数 簇的个数、迭代次数、原始样本集(double型数值)
    public KMeansCluster(int k, int num, List<Double> datas) {
        this.k = k;
        this.num = num;
        this.datas = datas;
    }

    //检查输入数据的合法性
    private void check() {
        //簇的个数必须大于0
        if (k == 0)
            throw new IllegalArgumentException("k must be the number > 0");

        if (address == null && datas == null)
            throw new IllegalArgumentException("program can't get real data");
    }

    /**
     * 初始化数据
     *
     * @throws FileNotFoundException
     */
    public void init() throws FileNotFoundException {
        check();
        //读取文件，init data
        //处理原始数据
//        for (int i = 0, j = datas.size(); i < j; i++)
//            data.add(new Point(i, datas.get(i), 0));
    }

    /**
     * 改进的方法:最大距离法选择初始聚类中心
     * @return
     */
    public Set<Point> chooseCenter() {
        ArrayList<Double> x0 = new ArrayList();
        double y = 0.0;
        int elementSize= data.get(0).getX().size();//X的维度
        for(int k = 0; k < elementSize; k++) {
            for (int i = 0, n = data.size(); i < n; i++) {
                x0.add((Double)data.get(i).getX().get(k));
            }
        }
        for(int i = 0, n = data.size(); i < n; i++) {
            y += data.get(i).getY();
        }
        ArrayList<Double> x = new ArrayList();
        for(int k3 = 0; k3 < elementSize; k3++) {
            x.add((double)x0.get(k3) / (double) elementSize);
        }
        //样本中心点C
        Point C = new Point(-1, x, y / data.size());
        Set<Point> center = new HashSet<Point>();
        //将所有样本点的平均值作为第一个初始聚类中心加入center
        Point[] p = null;
        TreeSet<Distance> distence = new TreeSet<Distance>();//存放距离信息
        Point source;
        Point dest;
        boolean flag = false;
        //第一个初始聚类中心
        for (int i = 0, n = data.size(); i < n; i++) {
            //对每一个样本点都计算该样本点到C的距离,存储在distence中
            source = data.get(i);
            dest = C;
            distence.add(new Distance(source, dest, distance));
        }
        Distance max = distence.last();//获得该样本点距离所有簇最大距离的值
        center.add(max.getSource());
        //添加第2~k个聚类中心
        for (int i = 0, n = k - 1; i < n; i++) {
            //对每一个样本点都计算该样本点到簇中心点的距离,存储在distence中
            distence.clear();
            for (int j = 0; j < data.size(); j++) {
                if (center.contains(data.get(j)))//该样本点就是聚类中心点,则跳过
                    break;
                flag = true;
                // 计算距离
                p = center.toArray(new Point[0]);
                for (int k = 0; k < center.size(); k++) {
                    source = data.get(j);
                    dest = p[k];
                    distence.add(new Distance(source, dest, distance));
                }
            }
            if(flag) {
                max = distence.last();//获得距离池中最大的值
                center.add(max.getSource());
            }
            flag = false;
        }
        return center;
    }

    /**
     * @param center
     *
     * 将所有的中心点初始化到一个簇中
     * @return
     */
    public List<Cluster> prepare(Set<Point> center) {
        //定义一个簇的集合
        List<Cluster> cluster = new ArrayList<Cluster>();
        //迭代所有的中心点
        Iterator<Point> it = center.iterator();
        int id = 0;
        while (it.hasNext()) {
            Point p = it.next();
            //该点属于样本集,不仅要将该点设置为簇的中心点,也要加入到簇的成员中
            if (p.isBeyond()) {
                Cluster c = new Cluster(id++, p);
                //初始簇中心点本身属于簇的成员
                c.addPoint(p);
                cluster.add(c);
            } else {//该点不属于样本集,仅仅将该点设置为中心点即可
                cluster.add(new Cluster(id++, p));
            }
        }
        return cluster;
    }

    /**
     * *
     *  clustering()将所有样本点进行聚类,划分到各个簇中
     *  第一次运算，中心点为样本值
     *
     * @param center
     * @param cluster
     * @return
     */
    public List<Cluster> clustering (Set <Point> center, List <Cluster> cluster) {
        Point[] p = center.toArray(new Point[0]);
        TreeSet<Distance> distence = new TreeSet<Distance>();//存放距离信息
        Point source;
        Point dest;
        boolean flag = false;
        for (int i = 0, n = data.size(); i < n; i++) {
            //对每一个样本点都计算该样本点到簇中心点的距离,存储在distence中
            distence.clear();
            for (int j = 0; j < center.size(); j++) {
                if (center.contains(data.get(i)))//该样本点就是簇中心点,则跳过
                    break;
                flag = true;
                // 计算距离
                source = data.get(i);
                dest = p[j];
                distence.add(new Distance(source, dest, distance));
            }
            if (flag == true) {
                Distance min = distence.first();//获得该样本点距离所有簇最小距离的值
                for (int m = 0, k = cluster.size(); m < k; m++) {
                    if (cluster.get(m).getCenter().equals(min.getDest()))
                        cluster.get(m).addPoint(min.getSource());//将该样本点加入到距离它最近的簇
                }
            }
            flag = false;
        }
        return cluster;
    }

    /**
     * 迭代运算，中心点为簇内样本均值
     *
     * @param cluster
     * @return
     */
    public List<Cluster> clusters (List <Cluster> cluster) {
        Set<Point> lastCenter = new HashSet<Point>();
        for (int m = 0; m < num; m++) {
            Set<Point> center = new HashSet<Point>();
            // 重新计算聚类中心
            for (int j = 0; j < k; j++) {
                //得到簇i的所有成员
                List<Point> ps = cluster.get(j).getMembers();
                int size = ps.size();
                int elementSize = ps.get(0).getX().size();
                if (size < 3) {//簇的样本成员数量低于3,则不再计算
                    center.add(cluster.get(j).getCenter());
                    continue;
                }
                // 计算距离
                ArrayList<Double> x0 = new ArrayList();
                double y = 0.0;
                for (int k1 = 0; k1 < elementSize; k1++) {
                    for(int k2 = 0; k2 < size; k2++) {
                        x0.add((Double)ps.get(k2).getX().get(k1));
                    }
                }
                for(int i = 0, n = data.size(); i < n; i++) {
                    y += data.get(i).getY();
                }
                ArrayList<Double> x = new ArrayList();
                for(int k3 = 0; k3 < elementSize; k3++) {
                    x.add(x0.get(k3) / (double) elementSize);
                }
                //得到新的聚类中心点
                Point nc = new Point(-1, x , y / size, false);
                center.add(nc);
            }
            if (lastCenter.containsAll(center))//中心点不在变化，则表明已经收敛,退出迭代
                break;
            lastCenter = center;
            // 重新对所有的样本点进行聚类划分运算
            cluster = clustering(center, prepare(center));
        }
        return cluster;
    }


    /**
     * 输出聚类信息到控制台
     *
     * @param cs
     */
    public void print(List<Cluster> cs) {
        for (int i = 0; i < cs.size(); i++) {
            Cluster c = cs.get(i);
            List<Point> p = c.getMembers();//得到当前簇的所有样本值
            System.out.print("No." + (i + 1) + " cluster:center(" + c.getCenter().getX()
                    + "," + c.getCenter().getY() + ")" + "[");
            for (int j = 0; j < p.size(); j++) {
                System.out.print("(" + p.get(j).getX() + "," + p.get(j).getY() + ")");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
