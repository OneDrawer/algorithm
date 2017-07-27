package leetcode;

/**
 * Created by xwz on 10/22/16.
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "5347289347529";
        String num2 = "57823957938577874893";
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        //int res = 0;
        int sum = 0;
        StringBuilder res = new StringBuilder();
        while(len1 >= 0 || len2 >= 0) {
            if(len1 > 0 && len2 >= 0)
                sum = (int)(num1.charAt(len1) - '0') + (int)(num2.charAt(len2) - '0') + carry;
            else {
                if(len1 >= 0) {
                    sum = (int)(num1.charAt(len1) - '0') + carry;
                }
                else {
                    sum = (int)(num2.charAt(len2) - '0') + carry;
                }
            }
            carry = sum / 10;
            res.append(sum % 10);
            --len1;
            --len2;
        }
        if(carry == 1)
            res.append(carry);
        System.out.println(res.reverse().toString());
    }
}
