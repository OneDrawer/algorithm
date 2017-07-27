package FileTest;

import java.io.*;

/**
 * Created by xwz on 8/31/16.
 */
public class CopyFoldersDemo {
    public static void main(String[] args) throws IOException {
        //封装数据源
        File srcFile = new File("src");
        //封装目的地File
        File destFile = new File("test");

        if(!destFile.exists()) {
            destFile.mkdir();
        }
        //复制文件夹功能
        copyFolder(srcFile, destFile);
    }

    private static void copyFolder(File srcFile, File destFile) throws IOException {
        //判断该文件是文件夹还是文件
        if (srcFile.isDirectory()) {
            File newFolder = new File(destFile, srcFile.getName());
            newFolder.mkdir();

            //获取该File对象下的所有文件或者文件夹File对象
            File[] fileArray = srcFile.listFiles();
            for (File file : fileArray) {
                copyFolder(file, newFolder);
            }
        } else {
            //文件
            File newFile = new File(destFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }
    }

    private static void copyFile(File srcFile, File newFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(newFile));

        //文件复制过程
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys);
        }

        bis.close();
        bos.close();
    }
}
