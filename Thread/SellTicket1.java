package Thread;

/**
 * Created by xwz on 9/3/16.
 */
public class SellTicket1 implements Runnable{
    private int tickets = 1000;
    private  Object obj = new Object();


    @Override
    public void run() {
        while (true) {
                synchronized (obj) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "正在出售第"
                                + (tickets--) + "张票");
                    }
                }
        }
    }
}
