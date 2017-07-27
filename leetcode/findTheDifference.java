package leetcode;

/**
 * Created by xwz on 9/8/16.
 */
public class findTheDifference {
    public static void main(String[] args) {
        String s = "abcdefgh";
        String t = "abcdefghl";
        char[] arrT = t.toCharArray();
        char[] arrS = s.toCharArray();

        int charOfS = 0;
        int charOfT = 0;
        //get the ^ of the string of s
        for(int begin = 0; begin < arrS.length; begin++) {
            charOfS = charOfS ^ arrS[begin];
        }
        System.out.println(charOfS);

        //get the ^ of the String of t
        for(int begin = 0; begin < arrT.length; begin++) {
            charOfT = charOfT ^ arrT[begin];
        }
        System.out.println(charOfT);
        int result = charOfS ^ charOfT;
        System.out.println((char)result);
    }
}
