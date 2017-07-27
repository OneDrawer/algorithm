package TreeMap;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by xwz on 8/25/16.
 *
 * 需求 "aabcababcdabcdeabcdeabaaabbabdabcfabcdf",获取字符串中每一个字母出现的次数
 */
public class TreeMapDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input a String:");
        String line = sc.nextLine();

        TreeMap<Character, Integer> tm = new TreeMap();

        char[] chs = line.toCharArray();

        for(char ch : chs) {
            Integer i = tm.get(ch);
            if(i == null) {
                tm.put(ch, 1);
            } else {
                i++;
                tm.put(ch, i);
            }
        }

        //遍历集合,得到键和值
        StringBuilder sb = new StringBuilder();
        Set<Character> set = tm.keySet();
        for(Character key : set) {
            Integer value= tm.get(key);
            sb.append(key).append("(").append(value).append(") ");
        }

        String result = sb.toString();
        System.out.println("result:" + result);
    }
}
