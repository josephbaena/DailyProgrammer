
// Problem statement: Given an array of integers, find the maximum and minimum of the array.
public class FindMaxAndMin {

    public static void main(String[] args) {
        int[] inputArray = {1, 5, 3, 7, -35, 57, 52, 7, 8, 2};
        printMaxMinDivideAndConquer(inputArray);
    }

    private static void printMaxMinBruteForce(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            if (value > max) {
                max = value;
            }

            if (value < min) {
                min = value;
            }
        }

        System.out.println("Max = " + max + "\tMin = " + min);
    }

    private static void printMaxMinTournament(int[] arr) {
        int max = arr[0], min = arr[0];

        int i;
        for (i = 0; i < arr.length/2; i++) {
            int first = arr[2 * i];
            int second = arr[2 * i + 1];

            if (first >= second) {
                if (first > max) max = first;
                if (second < min) min = second;
            } else {
                if (second > max) max = second;
                if (first < min) min = first;
            }
        }

        // handle case of array of odd length
        if (2*i < arr.length) {
            int last = arr[2*i];
            if (last > max) max = last;
            if (last < min) min = last;
        }

        System.out.println("Max = " + max + "\tMin = " + min);
    }

    private static void printMaxMinDivideAndConquer(int[] arr) {
        MaxMinPair result = getMaxMin(arr, 0, arr.length-1);
        System.out.println("Max = " + result.max + "\tMin = " + result.min);
    }

    private static MaxMinPair getMaxMin(int[] arr, int start, int end) {
        if (start > end) return null;

        if (start == end) return new MaxMinPair(arr[start], arr[end]);

        MaxMinPair leftHand = getMaxMin(arr, start, (start + end)/2);
        MaxMinPair rightHand = getMaxMin(arr, (start + end)/2 + 1, end);

        if (leftHand == null) return rightHand;
        else if (rightHand == null) return leftHand;
        else {
            int max = leftHand.max > rightHand.max ? leftHand.max : rightHand.max;
            int min = leftHand.min < rightHand.min ? leftHand.min : rightHand.min;
            return new MaxMinPair(max, min);
        }

    }

    static class MaxMinPair {
        int max, min;

        public MaxMinPair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
}
