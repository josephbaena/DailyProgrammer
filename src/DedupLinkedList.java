import java.util.HashSet;
import java.util.Set;

public class DedupLinkedList {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


    public static void main(String[] args) {
        Node list = prepareList();

        printList(list);
        dedupNoBuffer(list);
        printList(list);
    }

    public static void dedupWithBuffer(Node list) {
        Set<Integer> set = new HashSet<Integer>();

        Node prev = null;
        Node current = list;
        while (current != null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
            }
            set.add(current.value);
            prev = current;
            current = current.next;
        }
    }

    public static void dedupNoBuffer(Node list) {
        Node current = list;
        while (current != null) {
            Node lagger = current;
            Node runner = lagger.next;
            while (runner != null) {
                if (runner.value == current.value) {
                    lagger.next = runner.next;
                }
                lagger = runner;
                runner = runner.next;
            }
            current = current.next;
        }
    }

    private static Node prepareList() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(1);
        Node e = new Node(4);
        Node f = new Node(3);
        Node g = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        return a;
    }


    private static void printList(Node list) {
        Node start = list;
        while (start != null) {
            System.out.print("[" + start.value + "] --> ");
            start = start.next;
        }
        System.out.println("null");
    }
}
