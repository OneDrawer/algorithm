package day15.List;

import day15.ObjectArray.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xwz on 8/20/16.
 */
public class ListDemo6 {
    public static void main(String[] args) {
        List list = new ArrayList();

        Student s1 = new Student("lindaiyu", 12);
        Student s2 = new Student("liulaolao", 14);
        Student s3 = new Student("wangxifeng", 43);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        Iterator it = list.iterator();
        while(it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getName() + "------" + s.getAge());
        }

        for(int x = 0; x< list.size(); x++) {
            Student s = (Student) list.get(x);
            System.out.println(s.getName() + "------" + s.getAge());
        }
    }
}
