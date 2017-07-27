package Code;

import java.util.Scanner;

/**
 * Created by xwz on 4/10/17.
 */
public class jingdong1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        while(cin.hasNextInt()) {
            n = cin.nextInt();
            int[] vote = new int[n];
            for(int i = 0; i < n; i++) {
                vote[i] = cin.nextInt();
            }
            int max;
            int count = 0;
            while((max = getMaxIndex(vote)) != 0) {
                vote[max]--;
                vote[0]++;
                count++;
            }
            for(int i = 1; i < n; i++) {
                if (vote[0] == vote[i]) {
                    count++;
                    break;
                }
            }
            System.out.println(count);
        }
    }

    public static int getMaxIndex(int[] v) {
        int index = 0;
        for(int i = 1; i < v.length; i++) {
            if(v[i] > v[index])
                index = i;
        }
        return index;
    }
}
