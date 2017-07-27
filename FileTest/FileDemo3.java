package FileTest;

import java.io.File;
/**
 *
 *  Created by xwz on 8/27/16.
 */
public class FileDemo3 {
    public static void main(String[] args) {
        File srcFolder = new File("src");
        getAllJavaFilePaths(srcFolder);
    }

    private static void getAllJavaFilePaths(File srcFolder) {
        File[] filesArray = srcFolder.listFiles();

        if(filesArray != null) {
            for(File file : filesArray) {
                if (file.isDirectory()) {
                    getAllJavaFilePaths(file);
                } else {
                    if (file.getName().endsWith(".java")) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
