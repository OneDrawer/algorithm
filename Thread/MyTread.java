package Thread;

/**
 * Created by xwz on 9/2/16.
 */
public class MyTread extends Thread {
    public MyTread() {
    }

    public MyTread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for(int x = 0; x < 500; x++) {
            System.out.println(getName() + ":" + x);
        }
    }
}

