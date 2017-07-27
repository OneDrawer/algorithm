package algorithm;

/**
 * Created by xwz on 3/7/17.
 */
public class BinarySearch {
    public static int search(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low <= high) {
            mid = low + (high - low) >> 1;
            if (value > arr[mid]) {
                low = mid + 1;
            } else {
                if (value < arr[mid]) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
            return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[] {10,23,45,66,77,88,999,9088};
        int des = search(array, 66);
        System.out.println(des);
    }
}
