import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// check if these two words are anagrams
// Anagram =  the result of rearranging the letters of a word
// or phrase to produce a new word or phrase,
// using all the original letters exactly once

public class Anagrams {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstWord = reader.readLine();
        String secondWord = reader.readLine();

        if (isAnagram(firstWord, secondWord)) {
            System.out.println(firstWord + "\t" + secondWord + "\t===>\tIS ANAGRAM");
        } else {
            System.out.println(firstWord + "\t" + secondWord + "\t===>\tNOT ANAGRAM");
        }

    }

    private static boolean isAnagram(String firstWord, String secondWord) {
        // easy check: if lengths are not the same, return false
        if (firstWord.length() != secondWord.length()) return false;

        Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();

        for (char ch : firstWord.toLowerCase().toCharArray()) {
            if (frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, 1 + frequencyMap.get(ch));
            } else {
                frequencyMap.put(ch, 1);
            }
        }

        for (char ch : secondWord.toLowerCase().toCharArray()) {
            if (frequencyMap.containsKey(ch)) {
                int freq = frequencyMap.get(ch);
                if (freq == 0) return false;
                frequencyMap.put(ch, frequencyMap.get(ch) - 1);
            } else {
                return false;
            }
        }

        // loop through, check that all frequencies are zero
        for (char ch : frequencyMap.keySet()) {
            if (frequencyMap.get(ch) != 0) return false;
        }

        return true;
    }

}
