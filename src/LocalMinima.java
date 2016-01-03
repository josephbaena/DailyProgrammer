/**
 Given an array of unique integers whose first two numbers are decreasing and last two numbers are increasing,
 find a number in the array which is local minima.
 A number in the array is called local minima if it is smaller than both its left and right numbers.
 For example in the array 9,7,2,8,5,6,3,4
 2 is a local minima as it is smaller than its left and right number 7 and 8.
 Similarly 5 is another local minima as it is between 8 and 6, both larger than 5. You need to find any one of the local minima.
 */
public class LocalMinima {

    public static void main(String[] args) {
        int[] arr = {9, 7, 2, 8, 5, 6, 3, 4};

        if (!verifyArray(arr)) {
            System.out.println("Invalid array - first two must be decreasing, last two must be increasing");
            return;
        }

        System.out.println("Local minima: " + recFindLocalMinima(arr, 0, arr.length-1));
    }

    private static int recFindLocalMinima(int[] arr, int left, int right) {
        int mid = (left + right)/2;
        if ((arr[mid+1] > arr[mid]) && (arr[mid] < arr[mid-1])) {
            return arr[mid];
        }

        // something's got to be locally decreasing
        if (arr[mid-1] < arr[mid]) {
            return recFindLocalMinima(arr, left, mid-1);
        } else if (arr[mid+1] < arr[mid]) {
            return recFindLocalMinima(arr, mid+1, right);
        }

        return -1;
    }

    private static boolean verifyArray(int[] arr) {
        // length must be at least 4
        int len = arr.length;

        if (len < 4) return false;

        // first two numbers must be decreasing
        if (arr[0] <= arr[1]) return false;

        // last two numbers must be increasing
        if (arr[len-2] >= arr[len-1]) return false;

        return true;
    }
}
