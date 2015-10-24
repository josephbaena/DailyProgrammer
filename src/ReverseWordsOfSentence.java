import java.io.BufferedReader;
import java.io.InputStreamReader;

// Reverse the words in a given sentence. Words are always delimited by spaces.
public class ReverseWordsOfSentence {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        char[] letters = line.toCharArray();

        // reverse the entire string/array
        reverseString(letters, 0, letters.length - 1);

        // segment array into words
        int start = 0;
        while (start < letters.length-1) {
            int end = start+1;
            while ((end < letters.length) && (letters[end] != ' ')) {
                end++;
            }
            // reverse the words
            reverseString(letters, start, end-1);
            start = end+1;
        }

        System.out.println(new String(letters));
    }

    private static void reverseString(char[] letters, int start, int end) {
        while (start < end) {
            char temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            start++;
            end--;
        }
    }
}
