package day15.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xwz on 8/20/16.
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("javaEE");
        list.add("android");
        list.add("java");
        list.add("javaEE");

        Iterator it = list.iterator();
        while(it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }
    }
}
