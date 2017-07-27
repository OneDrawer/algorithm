package Thread;

/**
 * Created by xwz on 9/3/16.
 */
public class SellTicket extends Thread{
    private static int tickets = 100;

    @Override
    public void run() {
        while(true) {
            if(tickets > 0) {
                System.out.println(getName() + "正在售第" + (tickets--) + "张票");
            }
        }
    }
}
