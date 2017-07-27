package leetcode;

/**
 * Created by xwz on 10/17/16.
 *  字符串中连续出现最多的子串
 *
 string MaxTimesOfContinue(string str)
 {
     int len = str.length();
     int maxCount = 0;
     string longest = "";
     for (int i = 0; i < len; ++i)
     {
         for (int j = i + 1; j < len; ++j)
         {
             if (str.substr(i, j - i) == str.substr(j, j - i))
             {
                 int offset = j - i;
                 int count = 2;
                 for (int k = j + offset; j <= len; k += offset)
                 {
                     if (str.substr(i, offset) == str.substr(k, offset))
                         ++count;
                     else
                         break;
                 }
                 if (count > maxCount)
                 {
                     maxCount = count;
                     longest = str.substr(i, offset);
                 }
             }
         }
     }
     return longest;
 }
 */
public class MaxTimesOfContinue {
    /*
        字符串中连续出现最多的子串
     */
    public static void main(String[] args) {
        String str = "abcabcabcdeabababcabaaaaaa";
        int len = str.length();
        int maxCount = 0;
        String longest = "";
        for(int i = 0; i < len; ++i) {
            for(int j = i + 1; j < len; ++j) {
                //偏移量:offset
                int offset = j - i;
                //System.out.println(str.substring(i, j) + "  " + str.substring(j, j + offset));
                //if条件中的(j + offset < len)是为了防止字符串越界
                if((j + offset < len) && str.substring(i, j).equals(str.substring(j, j + offset))) {
                    //count表示的是重复字符串重复的次数
                    int count = 2;
                    for(int k = j + offset; k <= len && k + offset <= len; k += offset) {
                        /*for语句中的 k < len 条件判断是为了防止字符串越界
                          k += offset 正是为了找出连续的字符串
                         */
                        if(str.substring(i, j).equals(str.substring(k, k + offset))) {
                            ++count;
                        }
                        else
                            break;
                    }
                    if(count > maxCount) {
                        maxCount = count;
                        longest = str.substring(i, i + offset);
                    }
                }
            }
        }
        System.out.println(longest + ": " + maxCount);
    }
}
