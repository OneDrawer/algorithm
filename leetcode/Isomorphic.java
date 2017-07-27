package leetcode;

import java.util.HashMap;

/**
 * Created by xwz on 9/23/16.
 */
public class Isomorphic {
    public static void main(String[] args) {
        String s = "ab";
        String t = "ca";
        boolean flag = isIsomorphic(s, t);
        System.out.println(flag);
    }

    public static boolean isIsomorphic(String s, String t) {
        //两个字符串都为空
        if(s == "" && t == "") {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        HashMap<Character, Character> hm = new HashMap();
        int i = 0;
        //这里做s到t的映射
        for(char c : chs) {
            if(hm.get(c) == null) {
                //该key没有value, 则将t[i]作为value加进去
                hm.put(c, cht[i]);
            }
            else {//存在对应的key-value
                if(hm.get(c) != cht[i]) {
                    //已经存在的key-value中的value和t[i]不相等,说明匹配不上
                    return false;
                }
                else {
                    //这里匹配上了,则继续下一步
                    //continue;
                }
            }
            i++;
        }
        //这里做t到s的映射
        i = 0;
        hm.clear();
        for(char c : cht) {
            if(hm.get(c) == null) {
                //该key没有value, 则将s[i]作为value加进去
                hm.put(c, chs[i]);
            }
            else {//存在对应的key-value
                if(hm.get(c) != chs[i]) {
                    //已经存在的key-value中的value和s[i]不相等,说明匹配不上
                    return false;
                }
                else {
                    //这里匹配上了,则继续下一步
                    //continue;
                }
            }
            i++;
        }
        return true;
    }
}
