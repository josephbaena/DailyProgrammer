import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by josephbaena on 9/17/15.
 * https://www.reddit.com/r/dailyprogrammer/comments/3kx6oh/20150914_challenge_232_easy_palindromes/
 */
public class Palindromes {

    private static final boolean DEBUG = true;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numLines = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numLines; i++) {
            String rawLine = reader.readLine();
            String lineWithoutWhitespace = rawLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().replaceAll("\\s+","");
            builder.append(lineWithoutWhitespace);
        }

        String input = builder.toString();
        if (DEBUG) System.out.println("Input = " + input);

        // now check if the line is a palindrome
        if (isPalindrome(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }

    private static boolean isPalindrome(String input) {
        if (DEBUG) System.out.println("input = " + input);

        if (input.equals("")) {
            return true;
        }

        // check if first letter and last letter are the same
        int length = input.length();
        int firstIndex = 0;
        int lastIndex = length-1;


        if (DEBUG) {
            System.out.println("length = " + length + " firstIndex = " + firstIndex + " lastIndex = " + lastIndex);
        }

        if (input.charAt(firstIndex) == input.charAt(lastIndex)) {
            if ((firstIndex + 1) > lastIndex) {
                return true;
            }
            return isPalindrome(input.substring(firstIndex + 1, lastIndex));
        } else {
            return false;
        }
    }

}
