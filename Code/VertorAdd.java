package Code;

import java.util.Vector;

/**
 * Created by xwz on 9/13/16.
 */
public class VertorAdd {
    public static void main(String[] args) {
        Vector<Integer> V = new Vector();
////        for(int begin = 100; begin > 0; begin--) {
////            V.add(begin);
//        }
        V.add(1);
        V.add(1);
        V.add(1);
        V.add(2);
        V.add(2);
        V.add(2);
        V.add(1);
        V.add(1);
        V.add(2);
        for(int i : V) {
            System.out.println(i);
        }
    }
}
