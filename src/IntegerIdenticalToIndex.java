/**
 * Integers in an array are unique and increasingly sorted.
 * Please write a function/method to find an integer from the array who equals to its index.
 */
public class IntegerIdenticalToIndex {

    public static void main(String[] args) {
        int[] arr = {-3, -1, 1, 3, 5};

        int value = getValueEqualToIndex(arr);
        if (value != -1) {
            System.out.println("The integer identical to index is " + value + ".");
        } else {
            System.out.println("There is no integer identical to index.");
        }
    }

    private static int getValueEqualToIndex(int[] arr) {
        if (arr == null) return -1;
        if (arr.length == 0) return -1;

        int leftHand = 0;
        int rightHand = arr.length - 1;
        while (leftHand <= rightHand) {
            int mid = (leftHand + rightHand)/2;
            if (arr[mid] == mid) return mid;

            if (arr[mid] > mid) {
                rightHand = mid - 1;
            } else {
                leftHand = mid + 1;
            }
        }
        return -1;
    }
}
