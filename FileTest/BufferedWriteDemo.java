package FileTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by xwz on 8/30/16.
 */
public class BufferedWriteDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("bw.txt"));

        bw.write("hello");
        bw.write("world");
        bw.write("java");
        bw.flush();
        bw.close();
    }
}
