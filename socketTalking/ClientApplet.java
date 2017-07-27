package socketTalking;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by xwz on 3/31/17.
 */
public class ClientApplet extends Applet{
    public void init() {
        //String host = getParameter("localhost");
        //int port = Integer.parseInt(getParameter("6663"));
        setLayout(new BorderLayout());
        add("Center", new Client("localhost", 6666));
    }
}
