/**
 * Definition for a binary tree node.
 * public class TreeNode {
 */

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node == null) {
            return;
        }

        if (path.length() == 0) {
            path += node.val;
        } else {
            path += "->" + node.val;
        }
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            dfs(node.left, path, paths);
            dfs(node.right, path, paths);
        }
    }
}