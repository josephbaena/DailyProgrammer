import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        // populate stack with test data
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(9);
        stack.push(2);
        stack.push(6);

        sortStack(stack);

        while(!stack.isEmpty())
            System.out.println(" " + stack.pop());
        System.out.print("--- bottom of stack");
    }

    // pop everything off of the stack
    // start inserting, keep ordering such that bottom element >= top element

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return; // base case

        int value = stack.pop();
        sortStack(stack);
        insert(value, stack);
    }

    public static void insert(int value, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else if (stack.peek() > value) {
            stack.push(value);
        } else {
            int smallerValue = stack.pop();
            insert(value, stack);
            stack.push(smallerValue);
        }
    }

}
