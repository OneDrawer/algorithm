package Code;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by xwz on 3/28/17.
 */
public class BornPrime {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        ArrayList<ArrayList> res = new ArrayList<ArrayList>();
        while (cin.hasNextInt()) {
            int m = cin.nextInt();
            int n = cin.nextInt();
            ArrayList<Integer> lis = new ArrayList<Integer>();
            while (m+2 <= n) {
                if (prime(m) && prime(m + 2)) {
                    lis.add(m);
                    lis.add(m + 2);
                    m += 3;
                }
                m++;
            }
            res.add(lis);
        }
        for (int i = 0; i < res.size(); i++) {
            ArrayList al = new ArrayList(res.get(i));
            int size = al.size();
            if(size == 0) {
                System.out.println("no");
                continue;
            }
            for(int j = 0; j < size; j++) {
                System.out.print(al.get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static boolean prime(int n) {
        if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
