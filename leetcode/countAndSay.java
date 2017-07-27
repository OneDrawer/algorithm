package leetcode;

import day15.Generic.Inter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwz on 9/11/16.
 */
public class countAndSay {
    public static void main(String[] args) {
        int n = 231342;
        String tmpnumberStr = String.valueOf(n);
        char[] number = tmpnumberStr.toCharArray();
//        System.out.println(numberStr);
        HashMap<Character, Integer> nHashM = new HashMap<Character, Integer>();
        int len = 0;
        while(len < number.length) {
            if(nHashM.containsKey(number[len])) {
                nHashM.put(number[len], nHashM.get(number[len]) + 1);
            } else {
                nHashM.put(number[len], 1);
            }
            len++;
        }
        String result = "";
//        Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) nHashM.entrySet();
//        for(Map.Entry<Integer, Integer> hm : nHashM.entrySet()) {
//            result += hm.getKey().toString() + hm.getValue().toString();
//        }
        len = 0;
        while(len < number.length) {

            if(nHashM.containsKey(number[len])) {
                result += nHashM.get(number[len]).toString() + number[len];
                nHashM.remove(number[len]);
            }
            len++;
        }

//        char[] chs = result.toCharArray();
//        for(int begin = 0, end = result.length() - 1; begin < end; begin++, end--) {
//            char tmp;
//            tmp = chs[begin];
//            chs[begin] = chs[end];
//            chs[end] = tmp;
//        }

//        result = new String(chs);
        System.out.println(result);
        System.out.println("fs" + 10);
    }
}
