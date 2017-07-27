package Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xwz on 12/27/16.
 *
 * 可以顺序的获得锁
 */
public class FairLock implements Runnable{
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while(true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock rl = new FairLock();
        Thread t1 = new Thread(rl, "Thread_t1");
        Thread t2 = new Thread(rl, "Thread_t2");
        t1.start();
        t2.start();
    }
}
