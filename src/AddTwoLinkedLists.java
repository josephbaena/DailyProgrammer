public class AddTwoLinkedLists {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node list1 = prepareList1();
        Node list2 = prepareList2();

        printList(list1);
        printList(list2);
        Node sum = addLists(list1, list2);
        printList(sum);
    }

    private static Node addLists(Node n1, Node n2) {
        Node result = null;
        Node end = null;
        int carry = 0;

        while ((n1 != null) && (n2 != null)) {
            int digit = n1.value + n2.value + carry;

            if (digit >= 10) {
                carry = 1;
                digit = digit % 10;
            } else {
                carry = 0;
            }

            Node curr = new Node(digit);
            if (result == null) {
                result = curr;
            } else {
                end.next = curr;
            }

            end = curr;

            n1 = n1.next;
            n2 = n2.next;
        }

        if (carry != 0) {
            end.next = new Node(carry);
        }

        return result;
    }

    private static Node prepareList1() {
        Node a = new Node(6);
        Node b = new Node(1);
        Node c = new Node(7);
        a.next = b;
        b.next = c;
        return a;
    }

    private static Node prepareList2() {
        Node a = new Node(2);
        Node b = new Node(9);
        Node c = new Node(5);
        a.next = b;
        b.next = c;
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
