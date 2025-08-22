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
    }
}