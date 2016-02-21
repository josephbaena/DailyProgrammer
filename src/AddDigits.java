/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 */
public class AddDigits {

    public static void main(String[] args) {
        int num = 38;
        System.out.println("Result (slow) = " + addDigits(num));
        System.out.println("Result (fast) = " + addDigitsEfficiently(num));
    }

    private static int addDigits(int num) {
        String str = Integer.toString(num);
        if (str.length() == 1) {
            return num;
        }

        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            value += str.charAt(i) - '0';
        }

        return addDigits(value);
    }

    private static int addDigitsEfficiently(int num) {
        int rem = num % 9;
        if (rem == 0) return 9;
        return rem;
    }
}
