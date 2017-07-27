package Code;

import java.util.ArrayList;

/**
 * Created by xwz on 3/19/17.
 */
public class ArrayTest {
    public static void main(String[] args ) {
        int[][] arr0 = null;
        int[][] arr1;
        int[] arr2 = null;
        int[] arr3;

        int row = 3;
        int col = 3;
        arr0 = new int[row][col];
        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                System.out.print(arr0[i][j]);
            }
        }

        System.out.println();

        arr2 = new int[row];
        for(int i = 0; i < row; i++) {
            System.out.print(arr2[i]);
        }

        System.out.println();
        arr3 = new int[row];
        for(int i = 0; i < row; i++) {
            System.out.print(arr3[i]);
        }

        ArrayList<Integer> a = new ArrayList();
        a.add(12);
        a.add(134);
        ArrayList<ArrayList> A = new ArrayList<ArrayList>();
        for(int i = 0; i < 5; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(a);
            A.add(tmp);
        }
        a.clear();
        System.out.println(A);
    }
}
