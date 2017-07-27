package leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xwz on 9/11/16.
 */
public class firstUniqChar1 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        char[] chs = s.toCharArray();
        List list = Arrays.asList(chs);
        HashSet hs = new HashSet();
        Collections.addAll(hs, chs);

        System.out.println(chs.length);
        System.out.println(list.size());
        System.out.println(hs.size());
    }
}
