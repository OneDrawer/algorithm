package Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by xwz on 3/29/17.
 */
public class wanmei3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            HashSet<Integer> fruitValue = new HashSet<>();
            fruitValue.add(cin.nextInt());
            ArrayList<Integer> fV = new ArrayList<>(fruitValue);
            int presentValue = cin.nextInt();
//            if(presentValue < fV.get(0))
//                System.out.println("-1");
            int res = 0;
            while(presentValue > 0) {
                for(int i = fV.size() -1; i > -1; i--) {
                    res += (presentValue - presentValue % fV.get(i)) / fV.get(i);
                    presentValue = presentValue % fV.get(i);
                }
            }
            System.out.println(res);
        }
    }
}
