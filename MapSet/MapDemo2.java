package MapSet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xwz on 8/25/16.
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();

        //添加元素
//        System.out.println("put:" + map.put("wenzhang", "mayili"));
//        System.out.println("put:" + map.put("wenzhang", "yaodi"));
        map.put("dengchao", "sunli");
        map.put("huangxiaoming", "yangyin");
        map.put("zhoujielun", "caiyilin");
        map.put("liukaiwei", "yangma");

        System.out.println("get:" + map.get("zhoujielun"));
        System.out.println("get:" + map.get("zhoujie"));
        System.out.println("-------------------");

        //Set<K> keySet(): 获取集合中所有键的集合
        Set<String> set = map.keySet();
        for (String key: set) {
            System.out.println(key);
        }

        System.out.println("-----------------");

        //Collection<String> values():获取集合中所有值得集合
        Collection<String> con = map.values();
        for(String value : con) {
            System.out.println(value);
        }
    }
}
