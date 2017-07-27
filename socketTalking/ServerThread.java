package socketTalking;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by xwz on 3/30/17.
 */
public class ServerThread extends Thread{
    public Server server;
    private Socket socket;
    public ServerThread(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        start();
    }

    public void run() {
        try {
            DataInputStream din = new DataInputStream(socket.getInputStream());
            while(true) {
                //读取下一条消息
                String message = din.readUTF();
                System.out.println("Sending " + message);
                server.sendToAll(message);
            }
        } catch (EOFException ie) {
            //不需要发送异常消息
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            server.removeConnection(socket);
        }
    }
}
