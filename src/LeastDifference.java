import java.util.Arrays;

public class LeastDifference {

    // strategy O(n log n)
    // sort the array, go through the array
    // and find the least difference between two consecutive array elements

    public static void main(String[] args) {
        int[] array = {64,57,2,78,43,73,53,86};

        int leftHand = -2, rightHand = -1, minDiff = Integer.MAX_VALUE;

        // sort the array (in place)
        Arrays.sort(array);

        for (int i = 1; i < array.length; i++) {
            int first   = i - 1;
            int second  = i;
            int diff    = array[second] - array[first];
            if (diff < minDiff) {
                minDiff     = diff;
                leftHand    = first;
                rightHand   = second;
            }
        }

        System.out.println(array[leftHand] + " and " + array[rightHand] + " with difference " + minDiff);
    }
}
