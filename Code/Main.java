package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xwz on 3/28/17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
            int n = cin.nextInt();
            int k = cin.nextInt();
            int arr[] = new int[n];
            int i = 0;
            int tmp[] = new int[n];
            while (i < n) {
                arr[i] = cin.nextInt();
                tmp[i] = arr[i];
                i++;
            }
            Arrays.sort(tmp);
            int m = tmp[k-1];
            for (i = 0; i < n; i++) {
                if (arr[i] <= m) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
