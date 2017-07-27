package FileTest;

import java.io.*;

/**
 * Created by xwz on 8/30/16.
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        method1("test.png","copy1.png");
//        method2("test.png","copy2.png");
//        method3("test.png","copy3.png");
//        method4("test.png","copy4.png");
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");

    }

    //一个字节的Buffered流
    public static void method1(String srcString, String destString)
            throws IOException{
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcString));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destString));
        int by = 0;
        while((by = bis.read()) != -1) {
            bos.write(by);
        }
        bis.close();
        bos.close();
    }


    //数组的Buffered流
    public static void method2(String srcString, String destString)
            throws IOException{
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcString));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destString));
        byte[] bys = new byte[1024];
        int len;
        while((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bis.close();
        bos.close();
    }

    //一个字节的文件流
    public static void method3(String srcString, String destString)
            throws IOException{
        FileInputStream fis = new FileInputStream(srcString);
        FileOutputStream fos = new FileOutputStream(destString);
        int by = 0;
        while((by = fis.read()) != -1) {
            fos.write(by);
//            System.out.print(by);
        }
        fis.close();
        fos.close();
    }

    //字节数组文件流
    public static void method4(String srcString, String destString)
            throws IOException{
        FileInputStream fis = new FileInputStream(srcString);
        FileOutputStream fos = new FileOutputStream(destString);
        byte[]bys = new byte[1024];
        int len;
        while((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }
        fis.close();
        fos.close();
    }
}
