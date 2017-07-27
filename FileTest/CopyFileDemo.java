package FileTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xwz on 8/29/16.
 */
public class CopyFileDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");

        int by = 0;
        while((by = fis.read()) != -1) {
            fos.write(by);
        }

        //release resourse
        fis.close();
        fos.close();
    }
}
