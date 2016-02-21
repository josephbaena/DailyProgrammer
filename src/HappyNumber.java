/**
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 *
 * Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber {

    public static void main(String[] args) {
        int num = 19;
        System.out.println("Is " + num + " a happy number?");
        System.out.println(isHappy(num) ? "yes" : "no");
    }

    private static boolean isHappy(int num) {
        String str = Integer.toString(num);

        int sum = 0;
        for (char ch : str.toCharArray()) {
            int value = (ch - '0');
            sum += value * value;
        }

        return sum == 1 || isHappy(sum);
    }

}
