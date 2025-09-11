/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 */
class Solution {
    private int acc = 0;

    public TreeNode bstToGst(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(TreeNode node) {
        if (node == null) 
            return;
        reverseInorder(node.right);
        acc += node.val;              
        node.val = acc;               
        reverseInorder(node.left);
    }
}