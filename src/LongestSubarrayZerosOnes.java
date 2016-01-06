/**
 * You are given an array of 1's and 0's only. Find the longest subarray which contains equal number of 1's and 0's.
 */
public class LongestSubarrayZerosOnes {

    public static void main(String[] args) {
//        int[] arr = { 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0 };
//        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        int[] arr = {1, 1, 1, 1, 0, 0};

        System.out.println("arr.length = " + arr.length);

        System.out.println("=====");
        solutionInefficient(arr);

        System.out.println("=====");
        solutionEfficient(arr);
    }

    private static void solutionEfficient(int[] arr) {
        int[] startIndexArray = new int[2*arr.length + 1];
        for (int i = 0; i < startIndexArray.length; i++) startIndexArray[i] = -1; //initialize

        int maxStartIndex = 0, maxEndIndex = -1, maxLength = 0;

        int runningSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) runningSum--;
            if (arr[i] == 1) runningSum++;

            int currStart = startIndexArray[arr.length + runningSum];
            if (currStart == -1) {
                startIndexArray[arr.length + runningSum] = i;
            } else {
                int currentLength = i - currStart;
                if (currentLength > maxLength) {
                    maxEndIndex = i;
                    maxStartIndex = currStart + 1;
                    maxLength = currentLength;
                }
            }
        }

        System.out.println("indices (" + maxStartIndex + "," + maxEndIndex + ")");
        System.out.println("length=" + maxLength);
        printSubarray(arr, maxStartIndex, maxEndIndex);
    }

    private static void solutionInefficient(int[] arr) {
        int maxStartIndex = 0, maxEndIndex = -1, maxLength = 0;

        for (int i = 0; i < arr.length-1; i++) {
            int counter = -1;
            if (arr[i] == 1) counter = 1;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] == 0) counter--;
                else counter++;

                if (counter == 0) {
                    int currLength = j - i + 1;
                    if (currLength > maxLength) {
                        maxLength = currLength;
                        maxStartIndex = i;
                        maxEndIndex = j;
                    }
                }
            }
        }

        if (maxEndIndex == -1) {
            System.out.println("Could not find subarray of equal 1s and 0s");
        } else {
            System.out.println("indices (" + maxStartIndex + "," + maxEndIndex + ")");
            System.out.println("length=" + maxLength);
            printSubarray(arr, maxStartIndex, maxEndIndex);
        }
    }

    private static void printSubarray(int[] arr, int start, int end) {
        System.out.print("[ ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

}
