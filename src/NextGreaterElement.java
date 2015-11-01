//Given an array, print the Next Greater Element (NGE) for every element.
// The Next greater Element for an element x is the first greater element on the right side of x in array.
// Elements for which no greater element exist, consider next greater element as -1.
public class NextGreaterElement {

    public static void main(String[] args) {
//        int[] input = {4, 5, 2, 25};
//        int[] input = {13, 7, 6, 12};
        int[] input = {16, 17, 4, 3, 5, 2};

        int[] result = getNextGreaterElementFast(input);
        printArray(result);
    }

    // O(n^2) solution
    private static int[] getNextGreaterElementSlow(int[] input) {
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            boolean foundNextGreater = false;
            for (int j = i+1; j < input.length; j++) {
                if (input[j] > input[i]) {
                    result[i] = input[j];
                    foundNextGreater = true;
                    break;
                }
            }
            if (!foundNextGreater) {
                result[i] = -1;
            }
        }

        return result;
    }

    // O(n) solution
    private static int[] getNextGreaterElementFast(int[] input) {
        int[] result = new int[input.length];

        int greatestOnRight = -1;
        for (int i = input.length-1; i >= 0; i--) {
            int tmp = input[i];
            if (tmp > greatestOnRight) {
                result[i] = -1;
            } else {
                result[i] = greatestOnRight;
            }
            if (tmp > greatestOnRight) {
                greatestOnRight = tmp;
            }
        }

        return result;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
