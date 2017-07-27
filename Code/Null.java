package Code;

/**
 * Created by xwz on 3/22/17.
 */
public class Null {
    public static void print() {
        System.out.println("MTDP");
    }


    public static void main(String[] args) {
        try {
            ((Null) null).print();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
    }
}
