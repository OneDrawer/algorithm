package Hashmap;

import day15.ObjectArray.Student;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by xwz on 8/25/16.
 */
public class HashMapDemo3 {
    public static void main(String[] args) {
        HashMap<String, Student> hm = new HashMap();

        Student s1 = new Student("zhouxingchi", 23);
        Student s2 = new Student("liudehua",24);
        Student s3 = new Student("liangchaowei", 25);
        Student s4 = new Student("liujialin", 35);
        Student s5 = new Student("guofucheng", 45);

        hm.put("9787", s1);
        hm.put("9784", s2);
        hm.put("9788", s3);
        hm.put("9782", s4);
        hm.put("9781", s5);

        //遍历
        Set<String> set = hm.keySet();
        for(String key : set) {
            Student values = hm.get(key);
            System.out.println(key + "---" + values);
        }
    }
}
