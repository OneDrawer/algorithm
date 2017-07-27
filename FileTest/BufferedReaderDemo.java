package FileTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xwz on 8/30/16.
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bw.txt"));

        //方式1
//        int ch = 0;
//        while((ch = br.read()) != -1) {
//            System.out.print((char) ch);
//        }

        //方式2
        char[] chs = new char[1024];
        int len = 0;
        while((len = br.read(chs)) != -1) {
            System.out.print(new String(chs, 0, len));
        }

        br.close();
    }
}
