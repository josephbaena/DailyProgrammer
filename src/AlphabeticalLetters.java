/**
 * Created by josephbaena on 8/22/15.
 * https://www.reddit.com/r/dailyprogrammer/comments/3h9pde/20150817_challenge_228_easy_letters_in/
 */
public class AlphabeticalLetters {

    public static void main(String[] args) {
        String input = args[0];

        // convert to upper case if necessary
        String inputWord = input.toUpperCase();
        boolean isInOrder = inAlphabeticalOrder(inputWord);
        if (isInOrder) {
            System.out.println(input + " IN ORDER");
        } else {
            boolean isInReverseOrder = inReverseOrder(inputWord);
            if (isInReverseOrder) {
                System.out.println(input + " REVERSE ORDER");
            } else {
                System.out.println(input + " NOT IN ORDER");
            }
        }
    }

    private static boolean inAlphabeticalOrder(String inputWord) {
        char lastChar = 'A';
        int inputLength = inputWord.length();
        for (int i = 0; i < inputLength; i++) {
            char ch = inputWord.charAt(i);
            if (ch < lastChar) {
                return false;
            }
            lastChar = ch;
        }
        return true;
    }

    private static boolean inReverseOrder(String inputWord) {
        char lastChar = 'Z';
        int inputLength = inputWord.length();
        for (int i = 0; i < inputLength; i++) {
            char ch = inputWord.charAt(i);
            if (ch > lastChar) {
                return false;
            }
            lastChar = ch;
        }
        return true;
    }
}