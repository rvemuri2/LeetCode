/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Lowest Common Ancestor in a general binary tree (not necessarily a BST).
     *
     * Intuition:
     * - If the current node is null, no ancestor here -> return null.
     * - If the current node is either p or q, then the current node is part of the answer -> return it.
     * - Recurse on left and right subtrees.
     *     * If both sides return non-null, p and q are in different branches -> current node is LCA.
     *     * If only one side returns non-null, propagate that node upward (it's either p/q or their LCA).
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base cases
        if (root == null) return null;
        if (root == p || root == q) return root;

        // Recurse
        TreeNode left  = lowestCommonAncestor(root.left,  p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides found a node, current root is the LCA
        if (left != null && right != null) {
             return root;
        }
        
        return (left != null) ? left : right;
    }
}
