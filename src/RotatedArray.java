import java.util.Arrays;

/**
 * Created by josephbaena on 9/27/15.
 */

// Given 2 integer arrays,
// determine of the 2nd array is a rotated version of the 1st array.
// Ex. Original Array A={1,2,3,5,6,7,8} Rotated Array B={5,6,7,8,1,2,3}
public class RotatedArray {

    public static int[] arr1 = {1, 2, 3, 5, 6, 7, 8};
    public static int[] arr2 = {5, 6, 7, 8, 1, 2, 3};

    public static void main(String[] args) throws Exception {

        if (arr1.length != arr2.length) { // sanity check
            throw new RuntimeException("array lengths not equal");
        }

        int[] compareArr = arr2;
        for (int i = 0; i < arr1.length; i++) {
            if (Arrays.equals(arr1, compareArr)) {
                System.out.println("YES, IS ROTATED");
                return;
            }
            compareArr = rotateLeft(compareArr);
        }

        System.out.println("NO, NOT ROTATED");
    }

    private static int[] rotateLeft(int[] arr) {
        int first = arr[0];
        int[] rotated = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            rotated[i-1] = arr[i];
        }
        rotated[arr.length - 1] = first;
        return rotated;
    }

    // for debugging
    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]\n");
    }

}
