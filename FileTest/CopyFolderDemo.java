package FileTest;

import java.io.*;

/**
 * Created by xwz on 8/31/16.
 */
public class CopyFolderDemo {
    public static void main(String[] args) throws IOException {
        File srcFolder = new File("src//set");
        File destFolder = new File("src//jad");

        if(!destFolder.exists()) {
            destFolder.mkdir();
        }

        File[] fileArray = srcFolder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".java");
            }
        });

        //遍历该File数组, 得到每一个File对象,调用copyFile()方法实现文件复制
        for(File file : fileArray) {
//            System.out.println(file);
            String name = file.getName();
            File newFile = new File(destFolder, name);
            copyFile(file, newFile);
        }

        //在目的地目录下改名
        File[]  destFileArray = destFolder.listFiles();
        for(File destFile : destFileArray) {
            String name = destFile.getName();
            String newName = name.replace(".java", ".jad");

            File newFile = new File(destFolder,newName);
            destFile.renameTo(newFile);//实现改名
        }
    }

    //复制文件
    private static void copyFile(File file, File newFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(newFile));
        byte[] bys = new byte[1024];
        int len = 0;
        while((len = bis.read(bys)) != -1) {
            bos.write(bys);
        }

        bis.close();
        bos.close();
    }
}
