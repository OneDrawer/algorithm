package Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xwz on 12/16/16.
 */
public class RetrivePage {
    public static String downloadPage(String path) throws IOException {
        URL pageURL = new URL(path);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(pageURL.openStream()));
        String line;
        StringBuilder pageBuffer = new StringBuilder();
        while((line = reader.readLine()) != null) {
            pageBuffer.append(line + "\n");
        }
        return pageBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(RetrivePage.downloadPage("http://" +
                "www.scu.edu.cn"));
    }
}
