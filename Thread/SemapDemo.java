package Thread;

import java.util.concurrent.*;

/**
 * Created by xwz on 12/27/16.
 */
public class SemapDemo implements Runnable{
    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ":done");
            semp.release();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for(int i = 0; i<20; i++) {
            exec.submit(demo);
        }
        exec.shutdown();
        System.out.println("CPU数量:" + Runtime.getRuntime().availableProcessors());
    }
}
