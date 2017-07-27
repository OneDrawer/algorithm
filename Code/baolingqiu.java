package Code;

import java.util.HashMap;

/**
 * Created by xwz on 5/9/17.
 *
 * X 表示一个 strike
 / 表示一个 spare
 - 表示一个 miss
 | 表示一格的分界线
 || 之后的字符表示最后一格的额外机会

 实例 1
 输入：X|X|X|X|X|X|X|X|X|X||XX
 输出：300

 输入：9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||
 输出：90

 输入：5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5
 输出：150

 输入：X|7/|9-|X|-8|8/|-6|X|X|X||81
 输出：167

 */
public class baolingqiu {
    public static void main(String[] args) {
        //String result = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
        //String result = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";
        //String result = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";
        String result = "X|X|X|X|X|X|X|X|X|X||XX";
        int score = getScore(result);
        System.out.println(score);
    }

    public static int getScore(String res) {
        int score = 0;

        //将字符串分割
        String[] source = res.split("\\|");
        if(source.length == 12)
            source[10] = source[11];
        for(int i = 0; i < source.length; i++)
            System.out.println(source[i]);

        //对十个格子分数进行计算
        for(int i = 0; i < 10; i++){
            String tmp = source[i];//获得第i个格子的标记
            score += calScore(tmp, i, source);
        }
        return score;
    }

    public static int calScore(String flag, int i, String[] source) {
        HashMap map = new HashMap<Character, Integer>();
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('X', 10);
        map.put('-', 0);
        map.put('/', 10);
        //获得flag的长度
        int size = flag.length();
        int sco = 0;
        //size为1,则一定是X,strike
        if(size == 1) {
            if(source[i+1].length() == 2) {//下一格有两个记录
                if(source[i+1].charAt(1) != '/') {//下一个记录中不含有'/'
                    int first = (int) map.get(source[i + 1].charAt(0));
                    int second = (int) map.get(source[i + 1].charAt(1)) + first;
                    sco = 10 + (first > second ? first : second);
                }
                else {//下一格记录中含有'/'
                    sco = 10 + 10;
                }
            }
            else {// 下一个只要一个记录,则得再加上再下一格的记录
                //sco = 10 + (int)map.get(source[i+1].charAt(0)) + (int) map.get(source[i+2].charAt(0));
                sco = 10 + 10 + (int) map.get(source[i+2].charAt(0));
            }
        }
        //size为2,则有两种情况,第一就是有spare,第二就是没有spare
        if(size == 2) {//  4/|3/|2/|...的情况
            if(flag.charAt(1) == '/') {//spare
                sco = 10 + (int) map.get(source[i+1].charAt(0));
            }
            else {//非spare
                int first = (int) map.get(source[i].charAt(0));
                int second = (int) map.get(source[i].charAt(1)) + first;
                sco = first > second ? first : second;
            }
        }
        return sco;
    }
}
