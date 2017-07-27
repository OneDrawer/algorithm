package Thread;

/**
 * Created by xwz on 12/16/16.
 */
class Thread0 extends Thread {
    public void run() {
        System.out.println("Throwing in " + "MyThread");
        throw new RuntimeException();
    }
}

class ThreadTest {
    public static void main(String[] args) {
        Thread0 t = new Thread0();
        t.start();
        try {
            Thread.sleep(2000);
        }
        catch (Exception ex) {
            System.out.println("Caught it");
        }
        System.out.println("Exiting main");
    }
}

