package leetcode;

/**
 * Created by xwz on 9/18/16.
 */
public class Covert {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
    public static String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        //这里的sb[]必须初始化,不然会出现NullPointerException
        for(int i = 0; i < numRows; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        while(i < len) {
            //曲线在下降时将数据加入到sb中
            for(int index = 0; index < numRows && i < len; i++, index++) {
                sb[index].append(c[i]);
            }
            //曲线在上升时将数据加入到sb中
            for (int index = numRows - 2; i < len && index > 0; i++, index--) {
                sb[index].append(c[i]);
            }
        }
        //将所有的sb[]都加在一块
        for(i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
