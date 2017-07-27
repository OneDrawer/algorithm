package Code;

/**
 * Created by xwz on 9/12/16.
 */
public class str1 {
    public static void main(String[] args) {
        char[] chs = {'1','0','0','0','0','1','1','1'};
        StringBuilder sb = new StringBuilder().append(chs, 0, chs.length).reverse();
        System.out.println(sb.toString());
    }
}
