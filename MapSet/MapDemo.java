package MapSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwz on 8/24/16.
 *
 * Map:
 *      put();
 *      remove();
 *      containsKey();
 *      containsValue();
 *      keySet();
 *      get();
 *      value();
 *      entrySet();
 *      size();
 *
 *
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String , String>();

        //添加元素
//        System.out.println("put:" + map.put("wenzhang", "mayili"));
//        System.out.println("put:" + map.put("wenzhang", "yaodi"));
        map.put("dengchao", "sunli");
        map.put("huangxiaoming", "yangyin");
        map.put("zhoujielun", "caiyilin");
        map.put("liukaiwei", "yangma");
        // 输出集合名称
        System.out.println(map);

        System.out.println(map.remove("huangxiaoming"));
        System.out.println(map);
    }
}
