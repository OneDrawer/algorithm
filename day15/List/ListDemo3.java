package day15.List;

import day15.ObjectArray.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xwz on 8/20/16.
 */
public class ListDemo3 {
    public static void main(String[] args) {
        List list = new ArrayList();

        Student s1 = new Student("baigujing", 12);
        Student s2 = new Student("zhizhujing", 13);
        Student s3 = new Student("guanyin",20);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        Iterator it =list.iterator();
        while(it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getName() + "------" + s.getAge());
        }

    }
}
