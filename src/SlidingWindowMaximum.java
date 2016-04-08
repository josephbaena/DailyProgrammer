import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by josephbaena on 1/8/16.
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int w = 3;

        int[] result = getSlidingWindowMaximums_Inefficient(arr, w);
        printArray(result);
    }

    public static int[] getSlidingWindowMaximums_Inefficient(int[] arr, int w) {
        int[] result = new int[arr.length-w];
        for (int i = 0; i < arr.length-w; i++) {
            int max = arr[i];
            for (int j = 1; j <= w; j++) {
                max = (arr[i+j] > max) ? arr[i+j] : max;
            }
            result[i] = max;
        }
        return result;
    }

    public static int[] getSlidingWindowMaximums(int[] arr, int w) {
        int[] result = new int[arr.length - w];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        return result;
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}
