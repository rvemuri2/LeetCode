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
     * - It also becomes the child (left child) of the first greater element to its left (the new stack top after popping).
     * This ensures the max node stays closer to root and smaller nodes become children appropriately.
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> st = new ArrayDeque<>();
        for (int x : nums) {
            TreeNode curr = new TreeNode(x);
            // All smaller nodes to the left become left-children in chain
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