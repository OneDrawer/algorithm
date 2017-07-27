package FileTest;

import java.io.*;

/**
 * Created by xwz on 8/30/16.
 *
 * 复制文件的五种方式
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        String srcString = "a.txt";
        String destString = "b.txt";
        method1(srcString, destString);
//        method2(srcString, destString);
//        method3(srcString, destString);
//        method4(srcString, destString);
//        method5(srcString, destString);
    }

    //基本字符流一次读写一个字符
    private static void method1(String srcString, String destString)
            throws IOException {
        FileReader fr = new FileReader(srcString);
        FileWriter fw = new FileWriter(destString);

        int ch = 0;
        while((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fw.close();
        fr.close();
    }

    //基本字符流一次读写一个字符数组
    private static void method2(String srcString, String destString)
            throws IOException {
        FileReader fr = new FileReader(srcString);
        FileWriter fw = new FileWriter(destString);

        char[] chs = new char[1024];
        int len = 0;
        while((len = fr.read(chs)) != -1) {
            fw.write(chs, 0, len);
        }

        fw.close();
        fr.close();
    }

    //字符缓冲区一个读写一个字符
    private static void method3(String srcString, String destString)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destString));

        int ch = 0;
        while ((ch = br.read()) != -1) {
            bw.write(ch);
        }

        br.close();
        bw.close();
    }

    //字符缓冲区一次读写一个字符数组
    private static void method4(String srcString, String destString)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destString));

        char[] chs = new char[1024];
        int len = 0;
        while((len = br.read(chs)) != -1) {
            bw.write(chs, 0, len);
        }

        br.close();
        bw.close();
    }

    //字符缓冲区一次读写一个字符串
    private static void method5(String srcString, String destString)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destString));

        String line = null;
        while((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        bw.close();
        br.close();
    }
}
