package day15.List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwz on 8/20/16.
 */
public class ListDemo5 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("hello");
        list.add("world");
        list.add("java");

        for(int x = 0; x < list.size(); x++) {
            String s = (String) list.get(x);
            System.out.println(s);
        }
    }
}
