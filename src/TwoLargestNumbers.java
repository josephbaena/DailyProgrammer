/**
 * Write a program to find top two maximum numbers in the given array.
 */
public class TwoLargestNumbers {

    public static void main(String[] args) {
        int[] numbers = { 5, 34, 78, 2, 45, 1, 99, 23 };
        findTwoLargest(numbers);
    }

    private static void findTwoLargest(int[] numbers) {
        Integer biggerMax = null;
        Integer smallerMax = null;

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (biggerMax == null) {
                biggerMax = num;
            } else if (smallerMax == null) {
                smallerMax = num;
                if (smallerMax > biggerMax) {
                    // swap
                    int temp = smallerMax;
                    smallerMax = biggerMax;
                    biggerMax = temp;
                }
            } if (num > biggerMax) {
                smallerMax = biggerMax;
                biggerMax = num;
            } else if ((num < biggerMax) && (num > smallerMax)) {
                smallerMax = num;
            }
        }

        System.out.println("The two maximums are " + biggerMax + " and " + smallerMax);
    }
}
