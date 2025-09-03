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
 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }

    private int dfs(TreeNode node, TreeNode parent, TreeNode grand) {
        if (node == null) {
            return 0;
        }

        int add = (grand != null && (grand.val & 1) == 0) ? node.val : 0;

        int leftSum  = dfs(node.left,  node, parent);
        int rightSum = dfs(node.right, node, parent);

        return add + leftSum + rightSum;
    }
}
