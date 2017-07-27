package set;

import day15.ObjectArray.Student;

import java.util.HashSet;

/**
 * Created by xwz on 8/23/16.
 */
public class HashSetDemo2 {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<Student>();

        Student s1 = new Student("linqingxia", 23);
        Student s2 = new Student("liuyan", 22);
        Student s3 = new Student("wangzuxian", 24);
        Student s4 = new Student("linqingxia", 23);
        Student s5 = new Student("linqingxia", 24);
        Student s6 = new Student("fanbingbing", 21);

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        hs.add(s5);
        hs.add(s6);

        for(Student s : hs) {
            System.out.println(s.getName() + "---" + s.getAge());
        }
    }
}
