package Hashmap;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by xwz on 8/25/16.
 */
public class HashMapDemo2 {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap();

//        Integer i = new Integer(27);
        hm.put(27, "liqingxia");
        hm.put(24, "fengqingyang");
        hm.put(28, "liuyi");
        hm.put(30,"liqingxia");
// 八进制
//  hm.put(003,"hello");
//        hm.put(002, "hello");

        Set<Integer> set = hm.keySet();
        for(Integer key : set) {
            String value = hm.get(key);
            System.out.println(key + "---" + value);
        }
        System.out.println(hm);
    }
}
