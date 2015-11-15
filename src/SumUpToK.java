import java.util.HashSet;
import java.util.Set;

// Given a sorted integer array and an integer k,
// find two numbers which sum up to k.
public class SumUpToK {

    public static void main(String[] args) {
        // given: sorted array, k
        //int[] arr = {1,2,3,4,5,6,7,8,9,12,13,14,16,32,44};
        int[] arr = {14,16,32,1,2,3,4,5,6,7,8,9,44,12,13};
        int k = 16;

        sumUpToKUnsorted(arr, k);
    }

    public static void sumUpToKUnsorted(int[] arr, int k) {
        Set<Integer> set = new HashSet<Integer>();
        boolean found = false;

        for (int x : arr) {
            if (set.contains(k - x)) {
                System.out.println("The numbers that sum to " + k + " are " + x + " and " + (k-x));
                found = true;
            }
            set.add(x);
        }

        if (!found) System.out.println("No numbers could be found that sum up to " + k);
    }

    public static void sumUpToKSorted(int[] arr, int k) {
        int leftHand = 0, rightHand = arr.length-1;

        boolean found = false;
        while (leftHand < rightHand) {
            int sum = arr[leftHand] + arr[rightHand];
            if (sum == k) {
                System.out.println("The numbers that sum to " + k + " are " + arr[leftHand] + " and " + arr[rightHand]);
                found = true;
                rightHand--;
                leftHand++;
            } else if (sum > k) {
                rightHand--;
            } else if (sum < k) {
                leftHand++;
            }
        }

        if (!found) System.out.println("No numbers could be found that sum up to " + k);
    }

}
