// Given a number find the lowest number which is power of 2
// and greater than the given number.
public class NextPowerOfTwo {

    public static void main(String[] args) {
        long number = 140;
        System.out.println("The next larger power of two of " + number + " is " + findNextPowerOfTwo(number) + ".");
    }

    public static long findNextPowerOfTwo(long number) {
        long output = 1;
        while (number != 0) {
            number = number >> 1;
            output = output << 1;
        }
        return output;
    }

}
