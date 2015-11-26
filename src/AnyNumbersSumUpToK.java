// Given an integer array and a number k.
// Find out whether it is possible to have a sum k
// by using any number of numbers from the array.
public class AnyNumbersSumUpToK {

    public static void main(String[] args) {
        int[] arr = {4,6,2,8};
        int k = 8;
        System.out.println("Is it possible? " + (recSum(arr, 0, k) ? "yes!": "no!"));
    }

    private static boolean recSum(int[] arr, int index, int remaining) {
        if (remaining == 0) return true;
        if ((remaining < 0) ||  (index >= arr.length)) return false;

        // either add this or don't add this
        int current = arr[index];

        if (recSum(arr, index+1, remaining-current)) return true;
        return recSum(arr, index+1, remaining);
    }

}
