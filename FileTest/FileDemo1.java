package FileTest;

import java.io.File;

/**
 * Created by xwz on 8/26/16.
 *
 * 我们想要实现IO的操作,就必须知道硬盘上的文件的表现形式
 * 而Java就提供了一个类File供我们使用
 *
 * FileTest:文件和目录(文件夹)路径名的抽象表现形式
 *
 *      FileTest(String pathname):根据一个路径得到File对象
 *      FileTest(String parent, String child):根据一个目录和一个子文件\目录得到File对象
 *      FileTest(FileTest parent, String child):根据一个父File和一个子文件\目录得到File对象
 *
 */
public class FileDemo1 {
    public static void main(String[] args) {
        File file = new File("~//InterllijProject//itcast//fileTest");
        File file2 = new File("~//InterllijProject//itcast", "fileTest");
        File file3 = new File("~//InterllijProject//itcast");
        File file4 = new File(file3, "itcast");

    }
}
