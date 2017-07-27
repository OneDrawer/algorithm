package day15.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xwz on 8/20/16.
 */
public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("hello");
        list.add("world");
        list.add("java");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }
    }
}
