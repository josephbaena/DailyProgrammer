import java.util.Stack;

//Implement a stack which provides an efficient get minimum function
// along with regular push and pop functionality.
public class GetMinimumStack {

    private Stack<Integer> originals = new Stack<Integer>();
    private Stack<Integer> minimums = new Stack<Integer>();

    public Integer pop() {
        if (originals.isEmpty()) return null;
        minimums.pop();
        return originals.pop();
    }

    public void push(int value) {
        originals.push(value);
        if (minimums.empty()) {
            minimums.push(value);
        } else {
            int min = minimums.peek();
            if (value < min) {
                minimums.push(value);
            } else {
                minimums.push(min);
            }
        }
    }

    public boolean isEmpty() {
        return originals.isEmpty();
    }

    public Integer peek() {
        return originals.peek();
    }

    public int size() {
        return originals.size();
    }

    public Integer getMinimum() {
        if (minimums.isEmpty()) return null;
        return minimums.peek();
    }


}
