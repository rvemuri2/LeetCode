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
    // Running sum of all nodes visited so far (from greatest downwards)
    private int runningSum = 0;

    /**
     * Converts a BST to a Greater Sum Tree (GST).
     * For each node, sets node.val = original node.val + sum of all keys greater than it.
     * Uses reverse in-order traversal to accumulate the running sum of greater keys.
     *
     * Time:  O(n)  (each node visited once)
     * Space: O(h)  recursion stack (h = tree height; O(n) worst-case skew, O(log n) average for balanced)
     */
    public TreeNode bstToGst(TreeNode root) {
        reverseInOrder(root);
        return root;
    }

    private void reverseInOrder(TreeNode node) {
        if (node == null) return;

        // 1) Visit the right subtree (all keys greater than current node)
        reverseInOrder(node.right);

        // 2) Update current node with running sum
        runningSum += node.val;   // include current node's original value
        node.val = runningSum;    // assign the updated (greater-sum) value

        // 3) Visit the left subtree (smaller keys)
        reverseInOrder(node.left);
    }
}

/* ---------- Helpers + Tests ---------- */

class Main {
    // Build a tree from level-order array where nulls represent missing nodes
    static TreeNode fromLevelOrder(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Serialize tree to level-order array (trim trailing nulls)
    static List<Integer> toLevelOrder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n != null) {
                out.add(n.val);
                q.add(n.left);
                q.add(n.right);
            } else {
                out.add(null);
            }
        }
        // trim trailing nulls
        int k = out.size() - 1;
        while (k >= 0 && out.get(k) == null) k--;
        return out.subList(0, k + 1);
    }

    static void assertEquals(List<Integer> got, Integer[] expect, String name) {}
}