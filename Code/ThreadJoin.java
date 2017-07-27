package Code;

/**
 * Created by xwz on 12/25/16.
 */
class ThreadTesterA implements Runnable {

    private int counter;

    @Override
    public void run() {
        while (counter <= 10) {
            System.out.print("Counter = " + counter + " ");
            counter++;
        }
        System.out.println();
    }
}

class ThreadTesterB implements Runnable {

    private int i;

    @Override
    public void run() {
        while (i <= 10) {
            System.out.print("i = " + i + " ");
            i++;
        }
        System.out.println();
    }
}

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadTesterA());
        Thread t2 = new Thread(new ThreadTesterB());
        t1.start();
        //如果去掉t1.join()这个语句的话,输出的顺序可能就是乱序的
        //加上之后才会是顺序输出
//        t1.join(); // wait t1 to be finished
        t2.start();
        t2.join(); // in this program, this may be removed
    }
}

