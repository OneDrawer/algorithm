package leetcode;

import java.util.Arrays;

/**
 * Created by xwz on 9/13/16.
 */
public class computeArea {
    public static void main(String[] args) {
        System.out.println(computeArea(-2,-2,2,2,-1,4,1,6));
    }
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int result = Math.abs((A - C) * (B - D)) + Math.abs((E - G) * (H - F));
        if((A < C && C < E && E < G) || (E < G && G < A && A < C)
                || (F <  H && H < B && B < D) || (B < D && D < F && F < H))
            return result;
        else {
            int[] arrays1 = new int[4];
            int[] arrays2 = new int[4];
            arrays1[0] = A;
            arrays1[1] = C;
            arrays1[2] = E;
            arrays1[3] = G;
            Arrays.sort(arrays1);
            arrays2[0] = B;
            arrays2[1] = D;
            arrays2[2] = F;
            arrays2[3] = H;
            Arrays.sort(arrays2);

            int tmpresult = Math.abs(arrays1[1] - arrays1[2]) * Math.abs(arrays2[1] - arrays2[2]);
            result = result - tmpresult;
            return result;
        }
    }
}
