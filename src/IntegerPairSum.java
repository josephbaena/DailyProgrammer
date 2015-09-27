import java.util.HashMap;
import java.util.Map;

/**
 * Created by josephbaena on 9/27/15.
 */

// Find pairs in an integer array whose sum is equal to 10 (bonus: do it in linear time)
public class IntegerPairSum {

    private static int TARGET_SUM = 10;

    private static int[] arr = {2, 5, 7, 4, 8};

    // approach 1:  O(n^2) implementation where you brute force all the pairs

    // approach 2:  sort the array O(n log n) then for each x find 10 - x with binary search O(n log n)
    //              total time complexity is O(n log n)

    // approach 3:  add all the elements in the array into a hashmap O(n)
    //              then, for each x find 10 - x in the hashmap with constant time lookup for each x

    // Questions:   how to deal with duplicate numbers in the array?

    public static void main(String[] args) {
        int arrLength = arr.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arrLength; i++) {
            map.put(arr[i], 0);
        }

        boolean found = false;
        for (int i = 0; i < arrLength; i++) {
            int num = arr[i];
            int target = TARGET_SUM - num;
            if (map.containsKey(target)) {
                System.out.println("FOUND: " + num + " + " + target + " = " + TARGET_SUM);
                found = true;
            }
        }

        if (!found) System.out.println("NONE FOUND");
    }
}
