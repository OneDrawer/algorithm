package MapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xwz on 8/25/16.
 */
public class MapDemo3 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();

        map.put("yangguo", "xiaolongnv");
        map.put("guojing", "huangrong");
        map.put("yangkang", "munianci");
        map.put("chenxuanfeng", "meichaofeng");

        //遍历
        //获取所有的键
        Set<String> set = map.keySet();
        for(String key : set) {
            String value = map.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
