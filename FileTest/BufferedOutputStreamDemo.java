package FileTest;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xwz on 8/30/16.
 */
public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("bos.txt"));

        bos.write("hello".getBytes());

        bos.close();
    }
}
