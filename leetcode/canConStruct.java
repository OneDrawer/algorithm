package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwz on 9/11/16.
 */
public class canConStruct {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "ghjk";

        HashMap<Character, Integer> ranMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> magMap = new HashMap<Character, Integer>();
        char[] rans = ransomNote.toCharArray();
        char[] mags = magazine.toCharArray();

        //用HashMap集合统计ransonNote出现的字母
        for(Character ch : rans) {
            if(ranMap.containsKey(ch)) {
                ranMap.put(ch, ranMap.get(ch) + 1);
            } else {
                ranMap.put(ch, 1);
            }
        }

        //用HashMap集合统计Magazine出现的字母
        for(Character ch : mags) {
            if(magMap.containsKey(ch)) {
                magMap.put(ch, magMap.get(ch) + 1);
            } else {
                magMap.put(ch, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : ranMap.entrySet()) {
            if((magMap.get(entry.getKey()) == null) || (entry.getValue() > magMap.get(entry.getKey())))
                System.out.println("false");
//            if(entry.getValue() > magMap.get(entry.getKey()))//NullPointerException
//                System.out.println("false");
        }
    }
}
