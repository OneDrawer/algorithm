package day15.Generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xwz on 8/22/16.
 * 三种遍历方式:while/for/Iterator
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();

        array.add("hello");
        array.add("world");
        array.add("java");

        //迭代器遍历
        Iterator<String> it = array.iterator();
        while(it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        //普通for循环遍历
        for(int x = 0; x < array.size(); x++) {
            String s = array.get(x);
            System.out.println(s);
        }

        //增强for循环
        for(String s : array) {
            System.out.println(s);
        }
    }
}
