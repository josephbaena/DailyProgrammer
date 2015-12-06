/**
 *  Given an array where two neighboring elements are adjacent (in absolute difference 1),
 *  can you write an algorithm to search an element in the array and return its position?
 *  If the element appears multiple times, please return the first occurrence.
 */
public class SearchInAdjacentNumbers {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 5, 6, 7, 8, 9, 10, 9};

        // the key: use property that two neighboring elements are adjacent
        int target = 9;

        int pos = getPosition(arr, target);
        if (pos == -1) {
            System.out.println(target + " could not be found.");
        } else {
            System.out.println("The first occurrence of " + target + " is at position " + getPosition(arr, target) + ".");
        }
    }

    public static int getPosition(int[] arr, int target) {
        int pos = 0;
        while (arr[pos] != target) {
            int diff = target - arr[pos];
            pos += Math.abs(diff);
            if (pos > arr.length) return -1;
        }

        return pos;
    }

}
