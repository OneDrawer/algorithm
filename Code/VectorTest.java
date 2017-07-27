package Code;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by xwz on 7/3/17.
 */
public class VectorTest {
    private static ArrayList<Integer> vector = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            for(int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
                    }
                }
            });

            removeThread.start();
            printThread.start();

            while(Thread.activeCount() > 20);
        }
    }
}
