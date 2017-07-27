package Exception;

/**
 * Created by xwz on 8/26/16.
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        int a = 10;
        int b = 0 ;
        try {
            System.out.println(a / b) ;
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0.");
        }

        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("您访问了不该访问的索引");
        }
        System.out.println("over");
    }
}
