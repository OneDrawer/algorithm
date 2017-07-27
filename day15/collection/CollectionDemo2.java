package day15.collection;

import day15.ObjectArray.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by xwz on 8/20/16.
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();

        Student s1 = new Student("xiaoqiao", 15);
        Student s2 = new Student("daqiao", 16);
        Student s3 = new Student("diaochan", 22);
        Student s4 = new Student("sunshangxiang", 24);
        Student s5 = new Student();
        s5.setAge(23);
        s5.setName("huangyueying");

        c.add(s1);
        c.add(s2);
        c.add(s3);
        c.add(s4);
        c.add(s5);
        c.add(new Student("meinv",17));

        Iterator it = c.iterator();
        while(it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getName() + "------" + s.getAge());
        }
    }
}
