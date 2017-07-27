package day15.List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by xwz on 8/20/16.
 */
public class ListDemo8 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("hello");
        list.add("world");
        list.add("javaEE");
/*
        ListIterator lit = list.listIterator();
        while(lit.hasNext()) {
            String s = (String) lit.next();
            if("world".equals(s)) {
                lit.add("java");
            }
        }
        System.out.println("list" + list);
        */
        for(int x = 0; x < list.size(); x++) {
            String s = (String) list.get(x);
            if("world".equals(s)) {
                list.add("C#");
            }
        }
        System.out.println("list:" + list);
    }
}
