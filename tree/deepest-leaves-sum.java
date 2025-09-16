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
    private int maxDepth = -1;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // Leaf node
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                sum = node.val; // reset sum for deeper level
            } else if (depth == maxDepth) {
                sum += node.val; // add if same deepest level
            }
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    // --- Test harness ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(6);
        root1.left.left.left = new TreeNode(7);
        root1.right.right.right = new TreeNode(8);

        System.out.println("Example 1 Output: " + sol.deepestLeavesSum(root1)); // Expected: 15

        // Example 2: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
        Solution sol2 = new Solution();
        TreeNode root2 = new TreeNode(6);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(1);
        root2.right.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(9);
        root2.left.right.left = new TreeNode(1);
        root2.left.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);

        System.out.println("Example 2 Output: " + sol2.deepestLeavesSum(root2)); // Expected: 19

        // Example 3: Single node tree
        Solution sol3 = new Solution();
        TreeNode root3 = new TreeNode(10);
        System.out.println("Example 3 Output: " + sol3.deepestLeavesSum(root3));
    }
}