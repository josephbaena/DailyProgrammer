//import java.util.Queue;
//import java.util.Stack;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.ConcurrentLinkedQueue;
//
///**
// * Created by josephbaena on 1/10/16.
// */
//public class LongestPathInBinaryTree {
//
//    public static void main(String[] args) {
//
//        Node root = setupBinaryTree();
////        Queue<Node> longestPath = new ArrayBlockingQueue<Node>();
////        getLongestPath(root, longestPath);
//
//        System.out.println("Deepest level is = " + getDeepestNode(root, 0));
//
//        Stack<Node> deepestStack = deepestPath(root);
//        if (deepestStack == null) {
//            System.out.println("deepestStack is null");
//        }
//        int[] result = new int[deepestStack.size()];
//        int idx = result.length-1;
//        while (!deepestStack.empty()) {
//            Node n = deepestStack.pop();
//            result[idx] = n.value;
//            idx--;
//        }
//
//        printArray(result);
//    }
//
//    public static Stack<Node> deepestPath(Node tree) {
//        Stack<Node> currentPath = new Stack<Node>();
//
//        Stack<Node> deepestPath = recDeepestPath(tree, deepestPath, currentPath);
//
//        return deepestPath;
//    }
//
//    public static Stack<Node> recDeepestPath(Node node, Stack<Node> deepestPath, Stack<Node> currentPath) {
//        currentPath.push(node);
//
//        if ((node.left == null) && (node.right == null)) { // leaf node
//            return (Stack<Node>) currentPath.clone();
//        }
//
//        if (node.left != null) recDeepestPath(node.left, deepestPath, currentPath);
//        if (node.right != null) recDeepestPath(node.right, deepestPath, currentPath);
//
//        currentPath.pop();
//    }
//
//    public static int getDeepestNode(Node node, int level) {
//        level++;
//
//        if ((node.left == null) && (node.right == null)) {
//            return level;
//        }
//
//        return Math.max(getDeepestNode(node.left, level), getDeepestNode(node.right, level));
//    }
//
//
//    // set up sample binary tree
//    public static Node setupBinaryTree() {
//        Node a = new Node(7);
//        Node b = new Node(3);
//        Node c = new Node(12);
//        a.left = b;
//        Node d = new Node(1);
//        Node e = new Node(5);
//        b.left = d;
//        b.right = e;
//
//        a.right = c;
//        Node f = new Node(10);
//        Node g = new Node(17);
//        c.left = f;
//        c.right = g;
//
//        Node h = new Node(8);
//        Node i = new Node(11);
//        f.left = h;
//        f.right = i;
//
//        return a;
//    }
//
//    static class Node {
//        int value;
//        Node left;
//        Node right;
//
//        public Node(int value) {
//            this.value = value;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//    private static void printArray(int[] arr) {
//        System.out.print("[ ");
//        for (int x : arr) {
//            System.out.print(x + " ");
//        }
//        System.out.println("]");
//    }
//
//
//}
