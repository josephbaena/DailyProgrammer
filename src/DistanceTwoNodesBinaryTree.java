import java.util.ArrayList;
import java.util.List;

// Find the distance between two nodes in a binary tree.
public class DistanceTwoNodesBinaryTree {

    public static void main(String[] args) {
        Node tree = constructSampleBinaryTree();

        int value1 = 4;
        int value2 = 7;
        System.out.println("The distance between nodes with values " + value1 + " and " + value2 + " is " +
                findDistance(tree, value1, value2));
    }

    private static int findDistance(Node root, int val1, int val2) {
        List<Node> path1 = new ArrayList<Node>();
        getPathToNode(root, val1, path1);

        List<Node> path2 = new ArrayList<Node>();
        getPathToNode(root, val2, path2);

        int lengthToVal1 = path1.size();
        int lengthToVal2 = path2.size();
        if ((lengthToVal1 == 0) || (lengthToVal2 == 0)) return  -1;

        int lengthUntilMismatch = getLengthUntilMismatch(path1, path2);

        return lengthToVal1 + lengthToVal2 - 2*lengthUntilMismatch;
    }

    private static boolean getPathToNode(Node node, int target, List<Node> path) {
        if (node == null) return false;
        path.add(node);
        if (node.value == target) return true;

        if (getPathToNode(node.left, target, path) || getPathToNode(node.right, target, path)) {
            return true;
        } else {
            path.remove(node);
            return false;
        }
    }

    private static int getLengthUntilMismatch(List<Node> path1, List<Node> path2) {
        int index;
        for (index = 0; index < path1.size(); index++) {
            if (path1.get(index).value != path2.get(index).value) break;
        }
        return index;
    }

    public static Node constructSampleBinaryTree() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        f.left = g;
        f.right = h;

        return a;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
