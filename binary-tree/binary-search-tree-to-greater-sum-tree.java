/**
 * Definition for a binary tree node.
 * public class TreeNode {
 */
class Solution {
    private int runningSum = 0;
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