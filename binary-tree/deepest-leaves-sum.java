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
 */
class Solution {
    private int maxDepth = -1;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                sum = node.val;
            } else if (depth == maxDepth) {
                sum += node.val;
            }
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}