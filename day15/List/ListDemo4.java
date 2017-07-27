package day15.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwz on 8/20/16.
 */
public class ListDemo4 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("hello");
        list.add("world");
        list.add("java");

        list.add(1, "android");
//        problem code
//        list.add(10, "javaSE");

        System.out.println("get:" + list.get(1));
//        problem code: IndexOutOfBoundsException
//        System.out.println("get:" + list.get(10));
        System.out.println("list" + list);

        System.out.println("remove:" + list.remove(1));
        System.out.println("list" + list);

        System.out.println("set: " + list.set(1, "C++"));
        System.out.println("list:" + list);
    }
}
