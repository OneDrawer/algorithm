package Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xwz on 8/26/16.
 */
public class FinallyDemo {
    public static void main(String[] args) {
        String s = "2014-12-23";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            System.out.println("here code can be runned");
        }
        System.out.println(d);
    }
}
