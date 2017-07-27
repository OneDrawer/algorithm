package Thread;

/**
 * Created by xwz on 9/2/16.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyTread my1 = new MyTread("谢文舟");
        MyTread my2 = new MyTread("林青霞");
//        my1.setName("xxx");
//        my2.setName("yyy");
        my1.start();
        my2.start();

        System.out.println(Thread.currentThread().getName());
    }
}
