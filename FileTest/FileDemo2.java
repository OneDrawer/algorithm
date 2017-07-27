package FileTest;

import java.io.File;
import java.io.IOException;

/**
 * Created by xwz on 8/26/16.
 *
 * public boolean createNewFile():创建文件 如果存在这样的文件就不创建了
 * public boolean mkdir():创建文件夹,如果存在这样的文件夹就不创建了
 * public boolean mkdirs():创建文件夹, 如果父文件夹不存在,它会帮你创建
 */
public class FileDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("demo");
        System.out.println("mkdir:" + file.mkdir());

        File file2 = new File("demo//test");
        System.out.println("createNewFile:" + file2.createNewFile());

//        FileTest file3 = new FileTest("//testtest1//test3");
//        System.out.println("mkdir:" + file3.mkdir());
    }
}
