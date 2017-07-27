package FileTest;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by xwz on 8/29/16.
 */
public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("fis2.txt");

//        byte[] bys = new byte[115];
//        int len = 0;
//        while((len = fis.read(bys)) != -1) {
//            System.out.print(new String(bys, 0, len));
////            System.out.println(new String(bys));
//        }


        byte[] bys = new byte[1024];
        int len = 0;
        while((len = fis.read(bys)) != -1) {
            System.out.print(new String(bys, 0, len));
        }
        fis.close();
    }
}
