package Code;

/**
 * Created by xwz on 4/7/17.
 */
public class Result2015 {
    public static void main(String[] args) {
        int n = 2015;
        System.out.println(func(n));
    }

    static int func(int x)
    {
        int count = 0;
        while(x != 0)
        {
            count++;
            x = x&(x-1);
        }
        return count;
    }
}
