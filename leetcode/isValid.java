package leetcode;

/**
 * Created by xwz on 9/17/16.
 */
public class isValid {
    public static void main(String[] args) {
        String s = "([[()]()[()][]]){}";
        char[] chs = new char[s.length()];
        int index = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    chs[index++] = ch;
                    break;
                case ')':
                    //注意:这里的 index == 0这个条件必须写在前面，因为后面这个条件会改变index的🈯；
                    if ((index == 0) || (chs[--index] != '('))
                        System.out.println("false");
                    break;
                case '}':
                    if ((index == 0) || (chs[--index] != '{'))
                        System.out.println("fasle");
                    break;
                case ']':
                    if ((index == 0) || (chs[--index] != '['))
                        System.out.println("false");
                    break;
            }
        }
        if(index == 0)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
