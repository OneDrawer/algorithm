package FileTest;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xwz on 8/29/16.
 *
 * 不同系统的换行符号识别是不一样的
 *  windows:\r\n
 *  linux:\n
 *  Mac:\r
 *
 */
public class FileOutputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos2.txt", true);

        for(int x = 0; x < 10; x++) {
            fos.write(("hello" + x).getBytes());
            fos.write("\n".getBytes());
        }

        fos.close();
    }
}
