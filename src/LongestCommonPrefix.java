/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = {"abab", "ab", "abaab"};

        // find minimum length
        int minLength = Integer.MAX_VALUE;
        for (String s : arr) {
            if (s.length() < minLength)
                minLength = s.length();
        }

        int i;
        for (i = 0; i < minLength; i++) {
            Character ch = arr[0].charAt(i);
            for (int j = 1; j < arr.length; j++) {
                if (arr[j].charAt(i) != ch) {
                    System.out.println("Longest prefix length is = " + i);
                    return;
                }
            }
        }

        System.out.println("Longest prefix length is = " + i);
    }

}
