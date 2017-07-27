package Code;

/**
 * Created by xwz on 2/23/17.
 *
 * 类InAndDe用于比较i--和i++的运行时间
 */
public class InAndDe {
    public static void main(String[] args) {
        decrement();
        increment();
    }

    public static void decrement() {
        long start2 = System.currentTimeMillis();
        for(long i = 10000000000L; i > 0; i--) {
        }
        long end2 = System.currentTimeMillis() - start2;
        System.out.println(end2);
    }

    public static void increment() {
        long start = System.currentTimeMillis();
        for(long i = 1; i < 10000000000L; i++) {
        }
        long end1 = System.currentTimeMillis() - start;
        System.out.println(end1);
    }
}
