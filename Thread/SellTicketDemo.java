package Thread;

/**
 * Created by xwz on 9/3/16.
 */
public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicket st1 = new SellTicket();
        SellTicket st2 = new SellTicket();
        SellTicket st3 = new SellTicket();

        st1.setName("windows1");
        st2.setName("windows2");
        st3.setName("windows3");

        st1.start();
        st2.start();
        st3.start();

    }
}
