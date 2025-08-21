/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    // Constructor: push all left children starting from root
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    // Return next smallest number
    public int next() {
        // Top of stack is the smallest available
        TreeNode node = stack.pop();

        // If there is a right subtree, push all its left children
        if (node.right != null) {
            pushLeft(node.right);
        }

        return node.val;
    }

    // Check if we still have elements
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper: push left path into stack
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // --- Testing ---
    public static void main(String[] args) {
        // Example tree:
        //       7
        //      / \
        //     3   15
        //        /  \
        //       9    20
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator it = new BSTIterator(root);

        System.out.println(it.next());    // 3
        System.out.println(it.next());    // 7
        System.out.println(it.hasNext()); // true
        System.out.println(it.next());    // 9
        System.out.println(it.hasNext()); // true
        System.out.println(it.next());    // 15
        System.out.println(it.hasNext()); // true
        System.out.println(it.next());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */