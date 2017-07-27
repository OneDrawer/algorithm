package FileTest;

import java.io.File;

/**
 * Created by xwz on 8/26/16.
 */
public class FileDelete {
    public static void main(String[] args) {
        File file = new File("~//test//test1//test3");
        System.out.println("delete:" + file.delete());
    }
}
