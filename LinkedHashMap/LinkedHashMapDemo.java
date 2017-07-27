package LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by xwz on 8/25/16.
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> hm = new LinkedHashMap();

        hm.put("2345", "hello");
        hm.put("2354", "world");
        hm.put("2345", "hello");
        hm.put("1244", "java");
        hm.put("2354", "world");
        hm.put("4342", "javaee");

        Set<String> set = hm.keySet();
        for ( String key : set) {
            String value = hm.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
