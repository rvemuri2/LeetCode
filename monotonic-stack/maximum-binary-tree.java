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
public class Solution {
    /**
     * Construct Maximum Binary Tree in O(n) using a monotonic decreasing stack.
     *
     * Intuition:
     * - For each number, it becomes the parent of the last smaller element to its left (stack top after popping smaller ones).
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> st = new ArrayDeque<>();
        for (int x : nums) {
            TreeNode curr = new TreeNode(x);
            while (!st.isEmpty() && st.peek().val < x) {
                curr.left = st.pop();
            }
            if (!st.isEmpty()) {
                st.peek().right = curr;
            }
            st.push(curr);
        }
        TreeNode root = null;
        while (!st.isEmpty()) {
            root = st.pop();
        }
        return root;
    }
}