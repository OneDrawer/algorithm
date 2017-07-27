package FileTest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by xwz on 8/30/16.
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");
        FileWriter fw = new FileWriter("b.txt");

        //一次一个字符
        int ch = 0;
        while((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        //release resource
        fw.close();
        fr.close();
    }
}
