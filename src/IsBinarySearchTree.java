// Find whether a given binary tree is a binary search tree or not.
public class IsBinarySearchTree {

    public static void main(String[] args) {
        Node tree = constructSampleTree();

        System.out.println("Is BST? " + (isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "yes!": "no!"));
    }

    // it will be a BST if
    private static boolean isBST(Node root, int min, int max) {
        if (root == null) return true;

        boolean leftGood = true, rightGood = true, centerGood = false;

        // check left
        if (root.left != null) {
            leftGood = isBST(root.left, min, root.value);
        }

        // check center
        if ((root.value > min) && (root.value < max)) {
            centerGood = true;
        }

        // check right
        if (root.right != null) {
            rightGood = isBST(root.right, root.value, max);
        }

        // if all sides good, return true
        return (leftGood && centerGood && rightGood);
    }

    private static Node constructSampleTree() {
        Node a=new Node(12);
        Node b=new Node(3);
        Node c=new Node(15);
        Node d=new Node(10);
        Node e=new Node(14);
        Node f=new Node(17);
        Node g=new Node(4);
        Node h=new Node(11);
        Node i=new Node(5);
        a.left=b;
        a.right=c;
        b.right=d;
        c.left=e;
        c.right=f;
        d.left=g;
        d.right=h;
        g.right=i;

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
