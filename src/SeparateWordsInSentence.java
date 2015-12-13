// Given a valid sentence without any spaces between the words and a dictionary of valid english words,
// find the individual words in the sentence.
// For example, "therearesome" -> "there are so me" "somewordshiden" -> "so me words hi den"

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SeparateWordsInSentence {

    public static void main(String[] args) {
        String sentence = "therearesomewordshiddenhere";
        String[] dictionary = { "the", "a", "i", "here", "so", "hid", "there", "are",
                                "some", "word", "words", "hid", "hi", "hidden", "he",
                                "here", "her", "rear", "me", "den" };

        String[] result = separateSentenceIntoWordArray(sentence, dictionary);
        if (result != null) {
            for (String s : result) {
                System.out.print(s + " ");
            }
        } else {
            System.out.print("Cannot separate sentence");
        }
    }

    private static String[] separateSentenceIntoWordArray(String sentence, String[] dictArray) {
        // add words in dictArray to a data structure with O(1) lookup
        Set<String> dict = new HashSet<String>();
        for (String s : dictArray) {
            dict.add(s);
        }

        Stack<String> words = new Stack<String>();
        if (separate(sentence, dict, 0, words)) {
            return words.toArray(new String[] {});
        }
        return null;
    }

    private static boolean separate(String sentence, Set<String> dict, int index, Stack<String> words) {
        if ((sentence.length() == 0) || (index == sentence.length())) return true;

        boolean hasWord = false;

        for (int i = index+1; i <= sentence.length(); i++) {
            String leftSubstr = sentence.substring(index, i);
            if (dict.contains(leftSubstr)) {
                words.push(leftSubstr);
                if (separate(sentence, dict, i, words)) {
                    hasWord = true;
                    break;
                } else {
                    words.pop();
                }
            }
        }

        return hasWord;
    }

}
