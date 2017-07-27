package leetcode;

import java.util.Vector;

/**
 * Created by xwz on 9/13/16.
 */
public class countAndSay2 {
    public static void main(String[] args) {

    }
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        //递归求1~n
        String preString = countAndSay(n-1);
        char c = preString.charAt(0);
        int count = 1, strLen = preString.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < strLen; i++) {
            //当char c 和当前指针指向的char不一样时,则将字符c的个数和字符c加入到字符串中
            if(c != preString.charAt(i)){
                sb.append(count).append(c);
                c = preString.charAt(i);
                count = 1;
            }else{
                //当字符串c和当前指针的指向的值相等,则将字符串c的个数加1
                count++;
            }
        }
        //将最后一个字符串和该字符串的个数加入到字符串sb中
        sb.append(count).append(c);

        //将StringBuilder对象转换成String后返回
        return sb.toString();
    }
}
