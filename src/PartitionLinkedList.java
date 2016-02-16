/**
 * Created by josephbaena on 2/15/16.
 */
public class PartitionLinkedList {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {

    }

    private static Node partition(Node n, int partitionValue) {
        Node smallerList = null;
        Node biggerList = null;

        while (n != null) {
            Node next = n.next;
            if (n.value < partitionValue) {
                n.next = smallerList;
                smallerList = n;
            } else {
                n.next = biggerList;
                biggerList = n;
            }
            n = next;
        }

        if (smallerList == null) return biggerList;

        Node smallerEnd = smallerList;
        while (smallerEnd.next != null) {
            smallerEnd = smallerEnd.next;
        }

        smallerEnd.next = biggerList;
        return smallerList;
    }

}
