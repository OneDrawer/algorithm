package Code;

import java.util.Scanner;

/**
 * Created by xwz on 4/7/17.
 */
public class jingdong {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[][] state = new char[3][3];
        int X = 0;
        int O = 0;
        String str = null;
        while(cin.hasNextInt()) {
            for(int i = 0; i < 3; i++) {
                str = cin.nextLine();
                char[] ch = new char[3];
                ch = str.toCharArray();
                state[i][0] = ch[0];
                state[i][1] = ch[1];
                state[i][2] = ch[2];
//                if (state[i][j] == 'X')
//                    X++;
//                if (state[i][j] == 'O')
//                    O++;

            }
            //valid
            if(Math.abs(X - O) > 1) {
                System.out.println("x");
            }
            char flag = 'n';
            int count = 0;
            if((state[0][0] == state[0][1]) && (state[0][0] == state[0][2])) {
                flag = state[0][0];
                count++;
            }
            if((state[1][0] == state[1][1]) && (state[1][0] == state[1][2])) {
                flag = state[1][0];
                count++;
            }
            if((state[2][0] == state[2][1]) && (state[2][0] == state[2][2])) {
                flag = state[2][0];
                count++;
            }
            if((state[0][0] == state[1][0]) && (state[0][0] == state[2][0])) {
                flag = state[0][0];
                count++;
            }
            if((state[0][1] == state[1][1]) && (state[1][1] == state[2][1])) {
                flag = state[0][1];
                count++;
            }
            if((state[0][2] == state[1][2]) && (state[0][2] == state[2][2])) {
                flag = state[0][2];
                count++;
            }
            if((state[0][0] == state[1][1]) && (state[2][2] == state[0][0])) {
                flag = state[0][0];
                count++;
            }
            if((state[0][2] == state[1][1]) && (state[0][2] == state[2][0])) {
                flag = state[0][2];
                count++;
            }

            if(flag != 'n' && count == 1) {
                if(flag == 'O')
                    System.out.println("1 won");
                else
                    System.out.println("2 won");
            }

            if(flag != 'n' && count > 1)
                System.out.println("x");
            if(flag == 'n' && X+O == 9)
                System.out.println("Draw");
            if(flag == 'n' && Math.abs(X-O) == 1) {
                if(X > O)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
}
