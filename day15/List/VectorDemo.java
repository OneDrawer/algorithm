package day15.List;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by xwz on 8/22/16.
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector v = new Vector();

        v.addElement("hello");
        v.addElement("world");
        v.addElement("java");

        for(int x = 0; x < v.size(); x++) {
            String s = (String) v.elementAt(x);
            System.out.println(s);
        }

        System.out.println("-----------------");

        Enumeration en = v.elements();//返回的实现类的对象
        while(en.hasMoreElements()) {
            String s = (String) en.nextElement();
            System.out.println(s);
        }
    }
}
