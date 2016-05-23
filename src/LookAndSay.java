public class LookAndSay {

    public static void main(String[] args) {
        int n = 8;
        printLookAndSay(n);
    }

    public static void printLookAndSay(int n) {
        String current = "1";
        for (int i = 1; i <= n; i++) {
            System.out.println(current);
            current = printNthLookAndSay(current);
        }

        System.out.println(current);
    }

    private static String printNthLookAndSay(String current) {
        StringBuilder builder = new StringBuilder();

        char currChar = current.charAt(0);
        int countCurrChar = 0;
        char[] chars = current.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (currChar == chars[i]) {
                countCurrChar++;
            } else {
                builder.append(countCurrChar);
                builder.append(currChar);

                // reset
                currChar = chars[i];
                countCurrChar = 1;
            }
        }

        builder.append(countCurrChar);
        builder.append(currChar);

        return builder.toString();
    }
}
