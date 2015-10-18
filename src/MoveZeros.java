//You are given an integer array which contains some zeros.
// Move the zeros to the right side of the array with minimum number of swaps.
// The order of the original array can be destroyed.
public class MoveZeros {

    public static void main(String[] args) {
        //int[] arr = { 0, 5, 0, 2, 3, 0, 3, 5, 0 };
        int[] arr = { 0, 0, 0, 0, 5, 0, 2, 3, 0, 3, 5, 0 };
        printArray(arr);

        int leftHand = 0, rightHand = arr.length-1;

        while (leftHand < rightHand) {
            if (arr[rightHand] == 0) {
                rightHand--;
            } else {
                if (arr[leftHand] == 0) {
                    swap(arr, leftHand, rightHand);
                    rightHand--;
                }
                leftHand++;
            }
        }

        printArray(arr);
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }
}
