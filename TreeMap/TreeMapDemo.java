package TreeMap;

import java.util.Set;
import java.util.TreeMap;

/**
 * Created by xwz on 8/25/16.
 *
 * TreeMap:是基于红黑树的Map的接口实现
 *
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, String> tm = new TreeMap();

        tm.put("hello", "nihao");
        tm.put("world", "shijie");
        tm.put("java", "zhuawa");
        tm.put("world", "shijie2");
        tm.put("javaee", "zhuawaee");

        Set<String> set = tm.keySet();
        for(String key : set) {
            String value = tm.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
