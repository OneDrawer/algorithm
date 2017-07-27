package Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xwz on 8/26/16.
 */
public class ExceptionDemo2 {
    public static void main(String[] args) {
        System.out.println("Today weather is well");
        try {
            method();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("but today's PM2.5 is high");
    }

    private static void method() throws ParseException {
        String s = "2014-11-20";
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = spf.parse(s);
        System.out.println(d);
    }
}
