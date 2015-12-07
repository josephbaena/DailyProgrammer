/**
 *  Given an array and a value, how to implement a function to remove all instances of that value in place
 *  and return the new length?
 *  The order of elements can be changed.
 *  It doesn't matter what you leave beyond the new length.
 */
public class RemoveNumbersInArray {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 2, 3, 6};
        int target = 2;
        int length = removeNumbers(arr, target);

        System.out.println("length of original array is " + arr.length);
        System.out.println("length of shorter array is " + length);

    }

    private static int removeNumbers(int[] arr, int target) {
        int left = 0, right = arr.length-1;

        // move so that right pointer points before matching elems
        while (arr[right] == target) right--;

        while (left < right) {
            if (arr[left] == target) {
                swap(arr, left, right);
                right--;
            }
            left++;
        }

        return left;

    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
