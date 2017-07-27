package FileTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xwz on 8/30/16.
 */
public class CopyFileDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("c.txt");
        FileOutputStream fos = new FileOutputStream("d.txt");

        //copy data
        byte[] bys = new byte[1024];
        int len = 0;
        while((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        //release resourse
        fis.close();
        fos.close();
    }
}
