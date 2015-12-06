/**
 * Problem 1: Given an increasingly sorted array and a number s, please find two numbers whose sum is s.
 * If there are multiple pairs with sum s, just output any one of them.
 */
public class NumbersWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        int targetSum = 15;

        printTwoNumbersWithTargetSum(arr,targetSum);
    }

    public static void printTwoNumbersWithTargetSum(int[] arr, int targetSum) {
        int left = 0, right = arr.length-1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == targetSum) {
                System.out.println("Found! Two numbers that add to " + targetSum
                        + " are " + arr[left] + " and " + arr[right] + ".");
                return;
            } else if (targetSum > sum) {
                left++;
            } else if (targetSum < sum) {
                right--;
            }
        }

        System.out.println("Could not find two numbers in array that add to " + targetSum);
    }


}
