package day15.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by xwz on 8/19/16.
 * Collection:
 *      add();
 *      remove();
 *      contains();
 *      iterator();
 *      size();
 *      遍历:
 *          增强for
 *          迭代器
 *
 */
public class CollectionDemo {
    public static void main(String[] args) {
//        String s = "fs";
//        s.length();
//        int[] arr = {};
//        int x = arr.length;
//        接口不能实例化
//        Collection c = new Collection();
        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add("java");

        System.out.println("remove:" + c.remove("hello"));
        System.out.println(c);
    }
}
