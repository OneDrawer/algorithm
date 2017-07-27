package FileTest;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by xwz on 9/1/16.
 *
 * a.txt + b.txt + c.txt = d.txt
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException{
        Vector<InputStream> v = new Vector<InputStream>();

        InputStream s1 = new FileInputStream("a.txt");
        InputStream s2 = new FileInputStream("b.txt");
        InputStream s3 = new FileInputStream("c.txt");

        v.add(s1);
        v.add(s2);
        v.add(s3);


        Enumeration<InputStream> en = v.elements();
        SequenceInputStream sis = new SequenceInputStream(en);
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("copy.txt"));

        byte[] bys = new byte[1024];
        int len = 0;
        while((len = sis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bos.close();
        sis.close();
        Properties pro = new Properties();
        pro.setProperty("fs", "fjs");
    }
}
