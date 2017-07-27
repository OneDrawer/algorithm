package Code;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by xwz on 4/26/17.
 */
public class ali {
    public static void main(String[] args) {



        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        char[] chs = expr.toCharArray();
        int size = chs.length;
        ArrayList<Integer> strs = new ArrayList<Integer>();
        int res = 0;
        boolean go = false;
        for(int i = 0; i < size; i++) {
            if((chs[i] - '0' >= 0) && ( chs[i] - '0' <= 9)) {
                go = true;
                res = res * 10 + (chs[i] - '0');
                //if(strs.size() >= 16)
                //  return -2;
                //strs.add(chs[i] - '0');
                continue;
            }
            if(chs[i] == '^') {
                if(go == true) {
                    go = false;
                    if(strs.size() >= 16)
                        return -2;
                    strs.add(res);
                    res = 0;
                }
                if(strs.size() < 1)
                    return -1;
                int tmp = strs.get(strs.size()-1);
                tmp++;
                strs.remove(strs.size()-1);
                strs.add(tmp);
                continue;
            }
            if(chs[i] == '+') {
                if(go == true) {
                    go = false;
                    if(strs.size() >= 16)
                        return -2;
                    strs.add(res);
                    res = 0;
                }
                if(strs.size() < 2)
                    return -1;
                int a = strs.get(strs.size() -1);
                int b = strs.get(strs.size() -2);
                strs.remove(strs.size()-1);
                strs.remove(strs.size()-1);
                strs.add(a+b);
                continue;
            }
            if(chs[i] == '*') {
                if(go == true) {
                    go = false;
                    if(strs.size() >= 16)
                        return -2;
                    strs.add(res);
                    res = 0;
                }
                if(strs.size() < 2)
                    return -1;
                int a = strs.get(strs.size() -1);
                int b = strs.get(strs.size() -2);
                strs.remove(strs.size()-1);
                strs.remove(strs.size()-1);
                strs.add(a*b);
                continue;
            }
            if(chs[i] == ' ') {
                if(go == true) {
                    go = false;
                    if(strs.size() >= 16)
                        return -2;
                    strs.add(res);
                    res = 0;
                }
                continue;
            }
        }
        return strs.get(strs.size()-1);
    }
}
