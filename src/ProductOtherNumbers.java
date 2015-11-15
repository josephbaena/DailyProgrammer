// Given an array of numbers, nums,
// return an array of numbers products,
// where products[i] is the product of all nums[j], j != i
public class ProductOtherNumbers {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};

        productOtherNumbers(input);
    }

    private static void productOtherNumbers(int[] input) {
        int[] result = new int[input.length];

        int val = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = val;
            val *= input[i];
        }

        val = 1;
        for (int i = result.length-1; i >= 0; i--) {
            result[i] *= val;
            val *= input[i];
        }

        printArray(result);
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }
}
