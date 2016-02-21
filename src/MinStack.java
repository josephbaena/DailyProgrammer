/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class MinStack {

    static class Node {
        int value;
        int min;
        Node next;

        public Node(int value) {
            this.value = value;
            this.min = value;
            this.next = null;
        }
    }

    Node start;

    public void push(int value) {
        Node n = new Node(value);
        if (start != null) {
            n.next = start;
            n.min = (n.value < start.min) ? n.value : start.min;
        }
        start = n;
    }

    public void pop() {
        if (start != null) start = start.next;
    }

    public Integer top() {
        return (start == null) ? null : start.value;
    }

    public Integer getMin() {
        return (start == null) ? null : start.min;
    }

}
