// Given an integer array find the subarray which has the largest sum.
public class LargestSumSubarray {

    public static void main(String[] args) {
        //int[] arr = { 4, 3, -5, 0, 6, -8, 12, 3, -9, 2, 5, 8, -3, 4, 8, 0, 3, -3, -5, -9, 4, 2 };
        int[] arr = { -4, -3, -5, -6, -8, -12, -3, -9, -2, -5, -8, -3, -4, -8, -3, -3, -5, -9, -4, -2 };

        int currLeftHand = 0, currRightHand = 0, currSum = arr[0];
        int maxLeftHand = 0, maxRightHand = 0, maxSum = arr[0];

        while (currRightHand < arr.length) {
            currSum += arr[currRightHand];

            if (currSum > maxSum) {
                maxSum = currSum;
                maxLeftHand = currLeftHand;
                maxRightHand = currRightHand;
            }

            if (currSum <= 0) {
                currLeftHand = currRightHand + 1;
                currSum = 0;
            }
            currRightHand++;
        }

        System.out.println("Maximum sum = " + maxSum);
        if (maxLeftHand == maxRightHand) {
            System.out.println("Position [" + maxLeftHand + "]");
        } else {
            System.out.println("Positions [" + maxLeftHand + "," + maxRightHand + "]");
        }
    }
}
