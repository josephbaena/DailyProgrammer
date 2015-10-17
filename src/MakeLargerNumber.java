import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MakeLargerNumber {

    public static void main(String[] args) throws Exception {
        System.out.println("Enter a number:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int length = input.length();

        List<Integer> numbers = new ArrayList<Integer>();
        for (char ch : input.toCharArray()) {
            numbers.add(Integer.parseInt("" + ch));
        }

        // traverse input from right to left, find place where number changes
        int lastIndex = length-1;
        int previous = numbers.get(lastIndex);
        int turningPoint = -1;
        for (int i = lastIndex-1; i >= 0; i--) {
            int value = numbers.get(i);
            if (value < previous) {
                turningPoint = i;
                break;
            }
            previous = value;
        }

        if (turningPoint < 0) {
            System.out.println("no larger number can be made");
            return;
        }

        // find next larger digit compared to value at turningPoint
        int nextLargerRight = -1;
        int diff = Integer.MAX_VALUE;
        for (int i = turningPoint + 1; i < length; i++) {
            int currentValue = numbers.get(i);
            int currentDiff = currentValue - numbers.get(turningPoint);
            if (currentDiff < diff) {
                nextLargerRight = i;
                diff = currentDiff;
            }
        }

        if (nextLargerRight < 0) {
            System.out.println("ERROR");
            return;
        }

        swap(numbers, turningPoint, nextLargerRight);

        Collections.sort(numbers.subList(turningPoint+1, length));

        String output = "";
        for (int i = 0; i < numbers.size(); i++) {
            output += numbers.get(i);
        }

        System.out.println(output);
    }

    public static void swap(List<Integer> numbers, int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }
}
