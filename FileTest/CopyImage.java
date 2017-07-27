package FileTest;

import java.io.*;

/**
 * Created by xwz on 8/30/16.
 */
public class CopyImage {
    public static void main(String[] args) throws IOException {
        //String srcString = "copy1.png";
        //String destString = "CopyImage.png";
        File srcFile = new File("copy1.png");
        File destFile = new File("CopyImage.png");

        method1(srcFile, destFile);
//        method2(srcFile, destFile);
//        method3(srcFile, destFile);
//        method4(srcFile, destFile);
    }

    //基本字节流一次读写一个字节
    private static void method1(File srcFile, File destFile) throws IOException {
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        int by = 0;
        while((by = fis.read()) != -1) {
            fos.write(by);
        }

        fis.close();
        fos.close();
    }

    //基本字节流一次读写一个字节数组
    private static void method2(File srcFile, File destFile) throws IOException {
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        byte[] bys = new byte[1024];
        int len = 0;
        while((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        fis.close();
        fos.close();
    }

    //字节缓冲流一次写一个字节
    private static void method4(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destFile)
        );

        int by = 0;
        while((by = bis.read()) != -1) {
            bos.write(by);
        }

        bis.close();
        bos.close();
    }

    //字节缓冲流一次写一个字节数组
    private static void method3(File srcFile, File destFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destFile)
        );

        byte[] bys = new byte[1024];
        int len = 0;
        while((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bis.close();
        bos.close();
    }
}
