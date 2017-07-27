package socketTalking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by xwz on 3/31/17.
 */
public class Client extends Panel implements Runnable {

    //聊天窗口上的虚拟显示组件
    private TextField tf = new TextField();
    private TextArea ta = new TextArea();
    //通过套接字连接到客户端
    private Socket socket;
    private DataOutputStream dout;
    private DataInputStream din;
    public Client(String host, int port) {
        //启动屏幕
        setLayout(new BorderLayout());
        add("North", tf);
        add("Center", ta);
        //当用户名输入消息并敲击回车后, 需要发送消息,使用匿名类作为回调函数
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processMessage(e.getActionCommand());
            }
        });
        //连接到服务器
        try {
            //初始化连接
            socket = new Socket(host, port);
            System.out.println("connected to " + socket);
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            //启动接收消息背景线程
            new Thread(this).start();
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }

    private void processMessage(String message) {
        try {
            dout.writeUTF(message);//send it to the server
            tf.setText("已发送...");
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }

    //由背景线程运行,从其他窗口中显示消息
    @Override
    public void run() {
        try {
            while(true) {
                String message = din.readUTF();
                //从文本窗口显示
                ta.append(message + "\n");
            }
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }
}
