package day15.List;

import day15.ObjectArray.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by xwz on 8/20/16.
 */
public class ListDemo7 {
    public static void main(String[] args) {
        List list = new ArrayList();

        Student s1 = new Student("lindaiyu", 12);
        Student s2 = new Student("liulaolao", 14);
        Student s3 = new Student("wangxifeng", 43);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        ListIterator lit = list.listIterator();
        while(lit.hasNext()) {
            Student s = (Student) lit.next();
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
