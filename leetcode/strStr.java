package leetcode;

/**
 * Created by xwz on 9/12/16.
 */
public class strStr {
    public static void main(String[] args) {
        String haystack = "fsfdsfgs";
        String needle = "gs";
//        StringBuilder hay = new StringBuilder().append(haystack);
//        StringBuilder need = new StringBuilder().append(needle);
        int start = 0;
        int end = needle.length();
        while(end <= haystack.length()) {
            String tmp = haystack.substring(start, end);
            if(tmp.equals(needle)) {
                System.out.println(start);
            }
            start++;
            end++;
        }
        System.out.println("false");
    }
}
