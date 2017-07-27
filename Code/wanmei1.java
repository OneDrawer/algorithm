package Code;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by xwz on 3/29/17.
 */
public class wanmei1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            ArrayList<Integer> tmpRe = new ArrayList<>();
            while(n <= m) {
                int n0 = n;
                int a = n0 % 10;
                int b = (n0 / 10) % 10;
                int c = (n0 / 100) % 10;
                if(a*a*a + b*b*b + c*c*c == n0)
                    tmpRe.add(n0);
                n++;
            }
            re.add(tmpRe);
        }
        for(int i = 0; i< re.size(); i++) {
            if(re.get(i).size() == 0) {
                System.out.println("no");
                continue;
            }
            for(int j = 0; j < re.get(i).size(); j++) {
                System.out.print(re.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
