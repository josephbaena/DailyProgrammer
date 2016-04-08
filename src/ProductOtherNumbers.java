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

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];

        t1[0] = 1;
        t2[nums.length-1] = 1;

        //scan from left to right
        for(int i = 0; i < nums.length - 1; i++) {
            t1[i+1] = nums[i] * t1[i];
        }

        //scan from right to left
        for(int i = nums.length - 1; i > 0; i--) {
            t2[i-1] = t2[i] * nums[i];
        }

        //multiply
        for(int i = 0; i < nums.length; i++) {
            result[i] = t1[i] * t2[i];
        }

        return result;
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}
