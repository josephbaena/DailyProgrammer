import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceParentheses {
    //  Given a string of opening and closing parentheses, check whether it’s balanced.
    // We have 3 types of parentheses: round brackets: (), square brackets: [], and curly brackets: {}.

    static Map<Character, Character> parenthesesMap;

    public static void main(String[] args) {
        String input = "({}[{}])()";
        parenthesesMap = new HashMap<Character, Character>();
        parenthesesMap.put(')', '(');
        parenthesesMap.put('}', '{');
        parenthesesMap.put(']', '[');

        System.out.println("Result for string \"" + input + "\" is " + isBalancedRec(input, 0));
    }

    // implementation with an explicit stack
    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char currentCharacter = str.charAt(i);
            if ((currentCharacter == '(') || (currentCharacter == '{') || (currentCharacter == '[')) {
                stack.push(currentCharacter);
            } else {
                if (stack.pop() != parenthesesMap.get(currentCharacter)) return false;
            }
        }
        if (!stack.empty()) return false;
        return true;
    }

    private static boolean isBalancedRec(String str, int amount) {
        if (str.isEmpty()) {
            return amount == 0;
        }

        char curr = str.charAt(0);
        if (!parenthesesMap.containsKey(curr)) return isBalancedRec(str.substring(1), amount+1);
        else if (parenthesesMap.containsKey(curr)) return isBalancedRec(str.substring(1), amount-1);
        return false;
    }


}
