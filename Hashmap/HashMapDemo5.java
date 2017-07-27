package Hashmap;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by xwz on 8/25/16.
 */
public class HashMapDemo5 {
    public static void main(String[] args) {
        //创建集合对象
        HashMap<String, HashMap<String, Integer>> czbkMap = new HashMap();

        //创建基础班集合对象
        HashMap<String, Integer> jcMap = new HashMap();

        jcMap.put("xiewenzhou", 24);
        jcMap.put("xulong", 25);

        czbkMap.put("jc", jcMap);

        //创建就业班集合对象
        HashMap<String, Integer> jyMap = new HashMap();

        jyMap.put("xiewenzhou2", 26);
        jyMap.put("xulong2",37);

        czbkMap.put("jy", jyMap);

        //遍历集合
        Set<String> czbkMapSet= czbkMap.keySet();
        for(String czbkMapKey : czbkMapSet) {
            System.out.println(czbkMapKey + ":");
            HashMap<String, Integer> czbkMapValue = czbkMap.get(czbkMapKey);
            Set<String> czbkMapValueSet = czbkMapValue.keySet();
            for(String czbkMapValueKey : czbkMapValueSet) {
                Integer czbkMapValueValue = czbkMapValue.get(czbkMapValueKey);
                System.out.println("\t" + czbkMapValueKey + "\t" + czbkMapValueValue);
            }
        }
    }
}
