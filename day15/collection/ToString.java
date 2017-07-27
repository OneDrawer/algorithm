package day15.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by xwz on 8/23/16.
 * toString()方法
 */
public class ToString {
    public static void main(String[] args) {
        int[] arr = {12,23,54,32,54,32,54,23,2};
        char[] chs = {'a', 'f', 'r'};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(chs));

        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        System.out.println("c:" + c);
    }
}
