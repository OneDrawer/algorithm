package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwz on 9/11/16.
 */
public class firstUniqChar {
    public static void main(String[] args) {
        String s = "lllll";
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> chMap = new HashMap<Character, Integer>();

        //将字符串映射到字典中
        for(Character ch : chs) {
            if(chMap.containsKey(ch)) {
                chMap.put(ch, chMap.get(ch) + 1);
            } else {
                chMap.put(ch, 1);
            }
        }

        int index = chs.length;
        for(Map.Entry<Character, Integer> entry : chMap.entrySet()) {
            if(chMap.get(entry.getKey()) == 1 && s.indexOf(entry.getKey()) < index) {
                index = s.indexOf(entry.getKey());
            }
        }

        if(index == chs.length)
            index = -1;
        System.out.println(index);
    }
}
