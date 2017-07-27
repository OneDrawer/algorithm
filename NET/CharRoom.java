package NET;

import java.io.IOException;
import java.net.DatagramSocket;

/**
 * Created by xwz on 9/8/16.
 *
 * 通过多线程改进聊天程序, 这样我就可以实现在一个窗口发送和接受数据了
 */
public class CharRoom {
    public static void main(String[] args) throws IOException{
        DatagramSocket dsSend = new DatagramSocket();
        DatagramSocket dsReceive = new DatagramSocket(12306);

        SendThread st = new SendThread(dsSend);
        ReceiveThread rt = new ReceiveThread(dsReceive);

        Thread t1 = new Thread(st);
        Thread t2 = new Thread(rt);

        t1.start();
        t2.start();
    }
}
