package FileTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xwz on 8/29/16.
 */
public class FileOutputStreamDemo3 {
    public static void main(String[] args) throws IOException {
        //一起做异常处理
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("fos3.txt", true);
            fos.write("java".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
