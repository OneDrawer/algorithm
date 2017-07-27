package socketTalking;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by xwz on 3/30/17.
 */
public class Server {
    //用于接收连接的服务器套接字
    private ServerSocket ss;
    //从一个套接字到DataOutputStream对象的映射
    private Hashtable outputStreams = new Hashtable();

    public Server(int port) throws IOException {
        listen(port);//监听端口
    }

    private void listen(int port) throws IOException {
        ss = new ServerSocket(port);
        System.out.println("Listening on" + ss);
        while(true) {
            Socket s = ss.accept();
            System.out.println("connection from " + s);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            outputStreams.put(s, dout);//保存这个流,以避免再次创建
            new ServerThread(this, s);
        }
    }

    //获得对所有客户端OutputStream对象的枚举
    Enumeration getOutputStreams() {
        return outputStreams.elements();
    }

    //将同一个消息发给所有的客户
    void sendToAll(String message) {
        synchronized(outputStreams) {
            for(Enumeration e = getOutputStreams(); e.hasMoreElements();) {
                DataOutputStream dout = (DataOutputStream) e.nextElement();
                try {
                    dout.writeUTF(message);
                } catch (IOException ie) {
                    System.out.println(ie);
                }
            }
        }
    }

    //对发现的死连接,删除相应的线程
    void removeConnection(Socket s) {
        synchronized (outputStreams) {
            System.out.println("Removing connection to " + s);
            outputStreams.remove(s);
        }
        try {
            s.close();
        } catch (IOException ie) {
            System.out.println("Error closing " + s);
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt("6666");
        new Server(port);
    }
}
