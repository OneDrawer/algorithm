package leetcode;

/**
 * Created by xwz on 10/17/16.
 *
 int Comlen(char *str1, char *str2)
 {
     int i = 0;
     while(*str2 && (*str1++ == *str2++))
     ++i;
     return i;
 }

 int MaxLength(char *str)
 {
     if(str == NULL)
         return 0;
     int maxLen = 0;
     int n = strlen(str);
     int maxi, maxj;
     for (int i = 0; i < n; ++i)
     {
         for(int j = i + 1; j < n; ++j)
         {
             int thisLen = 0;
             if ((thisLen = Comlen(&str[i], &str[j])) > maxLen)
             {
                 maxLen = thisLen;
                 maxi = i;
                 maxj = j;
             }
         }
     }
     return maxLen;
 }
 */
public class MaxLength {
    public static void main(String[] args) {
        String str = "abcabcabcabcdefbacdefabcef";
        if(str == null)
            System.out.println("the string is null");
        int maxLen = 0;
        int n = str.length();
        int maxi = 0, maxj = 0;
        for(int i = 0; i < n; ++i) {
            String stri = str.substring(i, n);
            for(int j = i + 1; j < n; ++j) {
                int thisLen = 0;
                String strj = str.substring(j, n);
                //很明显,len(stri) > len(strj)
                if((thisLen = Comlen(stri, strj)) > maxLen) {
                    maxLen = thisLen;
                    maxi = i;
                    maxj = j;
                }
            }
        }
        System.out.println(str.substring(maxi, maxi + maxLen) + ": " + maxLen);
    }

    public static int Comlen(String str1, String str2) {
        /*int i = 0;
         while(*str2 && (*str1++ == *str2++))
         ++i;
         return i;
     */
        //
        int i = 0;
        int count = 0;
        /*只要取得str2的长度就可以,因为len(str1) > len(str2)
          str1和str2的字符一个一个比较,则str2率先结束
          */
        int len = str2.length();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        while(i < len && ch1[i] == ch2[i]) {
            ++count;
            ++i;
        }
        return count;
    }
}
