import java.util.HashMap;
import java.util.Map;

/**
 * Write a function which takes as input a phone number,
 * specified as a string of digits,
 * return all possible character sequences that correspond to the phone number.
 */
public class PhoneMnemonic {
    private static Map<Integer, String> digitStringMap;
    static {
        digitStringMap = new HashMap<Integer, String>();
        digitStringMap.put(0, "0");
        digitStringMap.put(1, "1");
        digitStringMap.put(2, "ABC");
        digitStringMap.put(3, "DEF");
        digitStringMap.put(4, "GHI");
        digitStringMap.put(5, "JKL");
        digitStringMap.put(6, "MNO");
        digitStringMap.put(7, "PQRS");
        digitStringMap.put(8, "TUV");
        digitStringMap.put(9, "WXYZ");
    }

    public static void main(String[] args) {
        printMnemonics("4693854");
    }

    public static void printMnemonics(String phoneNumber) {
        recPrintMnemonics(phoneNumber, 0, "");
    }

    public static void recPrintMnemonics(String phoneNumber, int index, String word) {
        if (index == phoneNumber.length()) {
            System.out.println(word);
            return;
        }

        int num = phoneNumber.charAt(index) - '0';
        String values = digitStringMap.get(num);

        for (char ch : values.toCharArray()) {
            recPrintMnemonics(phoneNumber, index+1, word + ch);
        }
    }

}
