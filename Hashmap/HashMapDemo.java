package Hashmap;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by xwz on 8/25/16.
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("it001", "mayun");
        hm.put("it002", "mahuateng");
        hm.put("it003", "qiaobusi");
        hm.put("it004", "zhaochaoyang");
        hm.put("it005", "qiubojun");

        Set<String> set = hm.keySet();
        for(String key : set) {
            String value = hm.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
