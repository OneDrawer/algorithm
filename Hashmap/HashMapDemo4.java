package Hashmap;

import day15.ObjectArray.Student;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by xwz on 8/25/16.
 */
public class HashMapDemo4 {
    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap();

        Student s1 = new Student("diaochan", 21);
        Student s2 = new Student("wangzhaojun" , 22);
        Student s3 = new Student("xisi", 24);
        Student s4 = new Student("yangyuhuan", 25);
        Student s5 = new Student("diaochan", 21);

        hm.put(s1, "1111");
        hm.put(s2, "1112");
        hm.put(s3, "1113");
        hm.put(s4, "1114");
        hm.put(s5, "1115");

        Set<Student> set = hm.keySet();
        for(Student key : set) {
            String value = hm.get(key);
            System.out.println(key.getName() + "---" + key.getAge() + "---" + value);
        }
    }
}
