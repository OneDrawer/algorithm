package day15.ArrayList;

import day15.ObjectArray.Student;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by xwz on 8/22/16.
 */
public class ArrayListDemo2 {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        Student s1 = new Student("wusong", 30);
        Student s2 = new Student("luzhisong", 32);
        Student s3 = new Student("lincong", 34);
        Student s4 = new Student("yangzhi", 32);

        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);

        Iterator it = array.iterator();
        while(it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getName() + "---" + s.getAge());
        }

        System.out.println("-----------------");

        for(int x = 0; x < array.size(); x++) {
            Student s = (Student) array.get(x);
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
