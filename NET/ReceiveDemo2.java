package NET;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by xwz on 9/8/16.
 */
public class ReceiveDemo2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(12345);

        //创建一个包裹
        byte[] bys = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bys, bys.length);

        //接受
        ds.receive(dp);

        //解析数据
        String ip = dp.getAddress().getHostAddress();
        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println("from" + ip + "data is:" + s);

        ds.close();
    }
}
