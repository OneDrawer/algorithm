package FileTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xwz on 8/29/16.
 *
 *  字节流复制图片
 */
public class CopyImageDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("collectionAndMap.png");
        FileOutputStream fos = new FileOutputStream("test.png");

        int by = 0;
        while((by = fis.read()) != -1) {
            fos.write(by);
        }

        fis.close();
        fos.close();
    }
}
