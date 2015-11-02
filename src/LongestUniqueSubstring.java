import java.util.HashSet;
import java.util.Set;

//Given a string find out the longest substring which has all unique letters, i.e. no letter is repeated.
public class LongestUniqueSubstring {

    public static void main(String[] args) {
        String input = "abacbdadbc";
        getLongestUniqueSubstring(input);
    }

    public static void getLongestUniqueSubstring(String input) {
        int leftHand = 0;
        int rightHand = 0;

        int maxLeftHand = -1;
        int maxRightHand = -1;
        int maxLength = -1;

        Set<Character> seenLetters = new HashSet<Character>();
        while (rightHand < input.length()) {
            char ch = input.charAt(rightHand);
            if (!seenLetters.contains(ch)) {
                seenLetters.add(ch);
                int length = rightHand - leftHand + 1;
                if (length > maxLength) {
                    maxLength = length;
                    maxLeftHand = leftHand;
                    maxRightHand = rightHand;
                }
                rightHand++;
            } else {
                // reset

                char charLeftHand = input.charAt(leftHand);
                seenLetters.remove(charLeftHand);
                leftHand++;

                if (charLeftHand == input.charAt(rightHand)) {

                    int length = rightHand - leftHand + 1;
                    if (length > maxLength) {
                        maxLength = length;
                        maxLeftHand = leftHand;
                        maxRightHand = rightHand;
                    }
                    rightHand++;
                }
            }
        }

        System.out.println("substring = " + input.substring(maxLeftHand, maxRightHand));
    }

}
