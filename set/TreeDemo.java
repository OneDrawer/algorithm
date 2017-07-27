package set;

import java.util.TreeSet;

/**
 * Created by xwz on 8/24/16.
 */
public class TreeDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<Integer>();

        ts.add(20);
        ts.add(30);
        ts.add(40);
        ts.add(90);
        ts.add(80);
        ts.add(50);
        ts.add(20);
        ts.add(54);

        for(Integer i : ts) {
            System.out.println(i);
        }
    }
}
