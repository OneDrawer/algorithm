package Code;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by xwz on 3/29/17.
 */
public class wanmei0 {
    public static void main(String[] args) {
//        System.out.println(Math.sqrt(101));
        Scanner cin = new Scanner(System.in);
        ArrayList<Double> re = new ArrayList<>();
        while(cin.hasNextInt()) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            double n0 = (double)n;
            double sum = 0;
            while(m > 0) {
                sum += n0;
                n0 = Math.sqrt(n0);
                m--;
            }
            re.add(sum);
        }
        DecimalFormat df   = new DecimalFormat("######0.00");
        for(int i = 0; i < re.size(); i++) {
            System.out.println(df.format(re.get(i)));
        }
    }
}
