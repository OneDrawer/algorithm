package FileTest;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xwz on 8/29/16.
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");
        fos.write("hello world".getBytes());
        fos.close();
    }
}
