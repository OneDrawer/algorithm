package MapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xwz on 8/25/16.
 *
 * Set<Map.Entry<K, V> entrySet():返回的是键值对对象的集合
 *
 */
public class MapDemo4 {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap();


        map.put("yangguo", "xiaolongnv");
        map.put("guojing", "huangrong");
        map.put("yangkang", "munianci");
        map.put("chenxuanfeng", "meichaofeng");

        //获取所有键值对对象的集合
        Set<Map.Entry<String, String>> set = map.entrySet();
        //遍历键值对对象的集合, 得到每一个键值对对象
        for(Map.Entry<String, String> me : set) {
            String key = me.getKey();
            String value = me.getValue();
            System.out.println(key + "----" + value);
        }
    }
}
