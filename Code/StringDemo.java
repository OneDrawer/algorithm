package Code;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by xwz on 8/30/16.
 */
public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "你好";
        byte[] bys = s.getBytes();

        System.out.println(Arrays.toString(bys));

        String ss = new String(bys);
        String ss2 = new String(bys, "UTF-8");//结果说明上面使用的utf-8
        System.out.println(ss);
        System.out.println(ss2);
    }
}
