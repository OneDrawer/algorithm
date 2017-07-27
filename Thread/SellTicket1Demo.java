package Thread;

/**
 * Created by xwz on 9/3/16.
 */
public class SellTicket1Demo {
    public static void main(String[] args) {
        SellTicket1 st = new SellTicket1();

        Thread t1 = new Thread(st, "窗口1");
        Thread t2 = new Thread(st, "窗口2");
        Thread t3 = new Thread(st, "窗口3");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
