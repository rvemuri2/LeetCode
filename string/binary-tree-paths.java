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

import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        // Start DFS with empty path
        dfs(root, "", paths);
        return paths;
    }

    // Helper DFS method
    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node == null) return;

        // Append current node's value to the path
        if (path.length() == 0) {
            path += node.val;
        } else {
            path += "->" + node.val;
        }

        // If it's a leaf, add the current path to the result list
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            // Continue DFS on left and right children
            dfs(node.left, path, paths);
            dfs(node.right, path, paths);
        }
    }

    // Test example
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, null, new TreeNode(5));
        root.right = new TreeNode(3);

        List<String> result = sol.binaryTreePaths(root);
    }
}