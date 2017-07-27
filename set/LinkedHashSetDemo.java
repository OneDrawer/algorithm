package set;

import java.util.LinkedHashSet;

/**
 * Created by xwz on 8/24/16.
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> hs = new LinkedHashSet<String>();

        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("world");
        hs.add("hello");

        for(String s : hs) {
            System.out.println(s);
        }
    }
}
