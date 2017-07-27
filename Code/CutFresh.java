package Code;

import day15.Generic.Inter;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xwz on 3/28/17.
 */
public class CutFresh {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] fresh = new int[n];
        int i = 0;
        String sumOfFresh = "0";
        String need = "0";
        while(i < n) {
            fresh[i] = cin.nextInt();
            sumOfFresh = add(sumOfFresh, String.valueOf(fresh[i]));
            i++;
        }
        System.out.println(sumOfFresh);
        for(i = 0; i < fresh.length - 1; i++) {
            need = add(need, sumOfFresh);
            sumOfFresh = sub(sumOfFresh, String.valueOf(fresh[i]));
        }
        System.out.println(need);
    }

    public static String add(String r,String s2){
        StringBuffer res = new StringBuffer();
        int n=0;
        for(int i=s2.length()-1;i>=0;i--){
            int temp = (r.charAt(i)-'0'+s2.charAt(i)-'0'+n);
            if(i==0){
                res.append(temp%10).append(temp/10==0?"":temp/10);
            }else{
                res.append(temp%10);
                n=temp/10;
            }
        }
        return kickZero(String.valueOf(res.reverse()));

    }

    public static String sub(String s1,String s2){
        boolean flag = false;
        StringBuffer res=new StringBuffer();
        int n=0;
        for(int i=s1.length()-1;i>=0;i--){
            Integer temp = s1.charAt(i)-'0'-s2.charAt(i)+'0'-n;
            temp = i==0?(temp==0?null:temp):temp;
            res.append(temp==null?"":temp>=0?temp:temp+10);
            n=temp==null?0:temp<0?1:0;
        }
        return kickZero(flag?String.valueOf(res.append("-").reverse()):String.valueOf(res.reverse()));
    }
    public static String kickZero(String s){
        //int i=0;
        while(s.length()>1){
            if('0'==s.charAt(0)){
                s=s.substring(1);
            }else{
                break;
            }
        }
        return s;
    }

}
