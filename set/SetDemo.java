package set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xwz on 8/23/16.
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("hello");
        set.add("world");
        set.add("java");

        for(String s : set) {
            System.out.println(s);
        }
    }
}
