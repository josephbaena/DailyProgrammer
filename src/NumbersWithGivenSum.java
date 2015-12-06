/**
 * Problem 1: Given an increasingly sorted array and a number s, please find two numbers whose sum is s.
 * If there are multiple pairs with sum s, just output any one of them.
 *
 * Problem 2: Given an array, please determine whether it contains three numbers whose sum equals to 0.
 */
public class NumbersWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        int targetSum = 24;

        printThreeNumbersWithTargetSum(arr,targetSum);
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

    public static void printThreeNumbersWithTargetSum(int[] arr, int targetSum) {
        for (int i = 0; i < arr.length; i++) {
            int[] result = findTwoNumbersWithSum(arr, (targetSum - arr[i]), i);
            if (result != null) {
                System.out.println("The three numbers with sum " + targetSum + " are: "
                    + result[0] + ", " + result[1] + ", " + arr[i] + ".");
                return;
            }
        }

        System.out.println("Could not find three numbers in array that add to " + targetSum);
    }

    private static int[] findTwoNumbersWithSum(int[] arr, int targetSum, int excludeIndex) {
        int left = 0, right = arr.length-1;

        while (left < right) {
            if (left == excludeIndex) left++;
            if (right == excludeIndex) right--;

            int sum = arr[left] + arr[right];

            if (sum == targetSum) {
                System.out.println("Found! Two numbers that add to " + targetSum
                        + " are " + arr[left] + " and " + arr[right] + ".");
                int[] toReturn = new int[2];
                toReturn[0] = arr[left];
                toReturn[1] = arr[right];
                return toReturn;
            } else if (targetSum > sum) {
                left++;
            } else if (targetSum < sum) {
                right--;
            }
        }

        System.out.println("Could not find two numbers in array that add to " + targetSum);
        return null;
    }

}
