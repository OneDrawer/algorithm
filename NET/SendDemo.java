package NET;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by xwz on 9/8/16.
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象
        DatagramSocket ds = new DatagramSocket();

        //创建数据
        byte[] bys = "hello, udp, 我来了".getBytes();
        int length = bys.length;
        InetAddress address = InetAddress.getByName("192.168.5.106");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bys, length, address, port);

        //调用Socket对象的发送方法发送数据包
        ds.send(dp);
        ds.close();
    }
}
