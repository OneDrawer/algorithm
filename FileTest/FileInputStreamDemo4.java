package FileTest;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by xwz on 8/29/16.
 */
public class FileInputStreamDemo4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("fis.txt");

//        int by = fis.read();
//        System.out.println(by);
//        System.out.println((char) by);
//
//        by = fis.read();
//        System.out.println(by);
//        System.out.println((char) by);
//
//        by = fis.read();
//        System.out.println(by);
//        System.out.println((char) by);

//        int by = fis.read();
//        while(by != -1) {
//            System.out.print((char) by);
//            by = fis.read();
//        }

        int by = 0;
        while((by = fis.read()) != -1) {
            System.out.println((char) by);
        }

        fis.close();
    }
}
