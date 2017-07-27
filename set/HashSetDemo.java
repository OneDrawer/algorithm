package set;

import java.util.HashSet;

/**
 * Created by xwz on 8/23/16.
 * HashSet:存储字符串并遍历
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();

        hs.add("hello");
        hs.add("world");
        hs.add("java");
        hs.add("world");

        for(String s : hs) {
            System.out.println(s);
        }
    }
}
