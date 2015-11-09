// Find all the permutations of a given string whose letters are unique.
public class Permutations {

    public static void main(String[] args) {
        permutationsRecursive("", "abcd");
    }

    public static void permutationsRecursive(String prefix, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            permutationsRecursive(prefix + remaining.charAt(i), remaining.substring(0,i) + remaining.substring(i+1));
        }
    }

}
