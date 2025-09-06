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
class Solution {
    // Running sum of all nodes visited so far (from greatest downwards)
    private int runningSum = 0;

    /**
     * Converts a BST to a Greater Sum Tree (GST).
     * For each node, sets node.val = original node.val + sum of all keys greater than it.
     * Uses reverse in-order traversal to accumulate the running sum of greater keys.
     *
     */
    public TreeNode bstToGst(TreeNode root) {
        reverseInOrder(root);
        return root;
    }

    private void reverseInOrder(TreeNode node) {
        if (node == null) return;

        reverseInOrder(node.right);

        runningSum += node.val;
        node.val = runningSum;

        reverseInOrder(node.left);
    }
}