package day15.List;

import java.util.LinkedList;

/**
 * Created by xwz on 8/22/16.
 *
 * public void addFirst(Object e)
 * public void addLast(Object e)
 *
 * public void getFirst()
 * public void getLast()
 *
 * public Object removeFirst()
 * public Object removeLast()
 */
public class LinkedListDemo {
    public  static void main(String[] args) {
        LinkedList link = new LinkedList();

        link.add("hello");
        link.add("world");
        link.add("java");

        link.addLast("android");

        System.out.println("link:" + link);

        System.out.println("getFirst:" + link.getFirst());
        System.out.println("getLast:" + link.getLast());

        System.out.println("removeFirst():" + link.removeFirst());
        System.out.println("removeLast():" + link.removeLast());
        System.out.println("link:" + link);
    }
}
