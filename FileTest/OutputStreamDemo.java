package FileTest;

import java.io.*;

/**
 * Created by xwz on 8/30/16.
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("b.txt"));

        //方式1 读写
//        int ch = 0;
//        while((ch = isr.read()) != -1) {
//            osw.write(ch);
//        }

        //方式2 读写
        char[] chs = new char[1024];
        int len = 0;
        while((len = isr.read(chs)) != -1) {
            osw.write(chs, 0, len);
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
