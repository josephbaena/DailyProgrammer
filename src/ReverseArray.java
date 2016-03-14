/**
 * Reverse order of elements in an array (without creating a new array)
 */
public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 8, 7, 2, 1};
        printArray(arr);
        reverseArray(arr);
        printArray(arr);
    }

    private static void reverseArray(int[] arr) {
        int mid = arr.length / 2;
        for (int i = 0; i < mid; i++) {
            swap(arr, i, arr.length - 1- i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }

}
