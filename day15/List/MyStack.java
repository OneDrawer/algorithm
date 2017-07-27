package day15.List;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by xwz on 8/22/16.
 */
public class MyStack {
    private LinkedList link;

    public MyStack() {
        link = new LinkedList();
    }

    public void add(Object obj) {
        link.addFirst(obj);
    }

    public Object get() {
//        return link.getFirst();
        return link.removeFirst();
    }

    public boolean isEmpty() {
        return link.isEmpty();
    }
}
