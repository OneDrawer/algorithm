package NET;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by xwz on 9/8/16.
 */
public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端Socket对象
        DatagramSocket ds = new DatagramSocket(10086);

        //创建一个数据包(接受容器)
        byte[] bys = new byte[1024];
        int length = bys.length;
        DatagramPacket dp = new DatagramPacket(bys, length);

        //调用Socket对象的接受方法接受数据
        ds.receive(dp);

        //解析数据包, 并显示在控制台
        InetAddress address = dp.getAddress();
        String ip = address.getHostAddress();

        byte[] bys2 = dp.getData();
        int len = dp.getLength();
        String s = new String(bys2, 0, len);
        System.out.println(ip + ":" + s);

        ds.close();
    }
}
