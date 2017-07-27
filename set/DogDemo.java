package set;

import java.util.HashSet;

/**
 * Created by xwz on 8/24/16.
 */
public class DogDemo {
    public static void main(String[] args) {
        HashSet<Dog> hs = new HashSet<Dog>();
        //创建狗对象
        Dog d1 = new Dog("qinhui", 25, "hongse", '男');
        Dog d2 = new Dog("gaoqiu", 23, "lanse", '女');
        Dog d3 = new Dog("qinhui", 25, "hongse", '男');
        Dog d4 = new Dog("weizongxian", 25, "hongse", '男');
        Dog d5 = new Dog("lilianying", 25, "hongse", '男');
        Dog d6 = new Dog("lilianying", 25, "hongse", '男');
        Dog d7 = new Dog("lilianying", 25, "hongse", '女');
        
        //添加对象
        hs.add(d1);
        hs.add(d2);
        hs.add(d3);
        hs.add(d4);
        hs.add(d5);
        hs.add(d6);
        hs.add(d7);

        //遍历
        for(Dog d : hs) {
            System.out.println(d.getName() + "---" + d.getAge() + "---" + d.getColor()
            + "---" + d.getSex());
        }
    }
}
