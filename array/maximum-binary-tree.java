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
                curr.left = st.pop(); // largest popped becomes direct left child
            }
            // The first greater on the left becomes parent; set curr as its right child
            if (!st.isEmpty()) {
                st.peek().right = curr;
            }
            st.push(curr);
        }
        // Bottom of the stack is the root
        TreeNode root = null;
        while (!st.isEmpty()) root = st.pop();
        return root;
    }

    /* -------------------- Helpers for testing & visualization -------------------- */

    // Serialize tree in level order including nulls (trim trailing nulls) e.g. [6,3,5,null,2,0,null,null,1]
    static List<Integer> levelOrderWithNulls(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                ans.add(null);
            } else {
                ans.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        // trim trailing nulls
        int i = ans.size() - 1;
        while (i >= 0 && ans.get(i) == null) i--;
        return ans.subList(0, i + 1);
    }

    // Pretty print the level-order list like the examples
    static String listFormat(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size(); i++) {
            Integer v = list.get(i);
            sb.append(v == null ? "null" : v.toString());
            if (i + 1 < list.size()) sb.append(',');
        }
        sb.append(']');
        return sb.toString();
    }

    /* ----------------------------------- Tests ----------------------------------- */
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3,2,1,6,0,5};
        TreeNode root1 = sol.constructMaximumBinaryTree(nums1);
        System.out.println("Example 1: " + listFormat(levelOrderWithNulls(root1)));
        // Expected: [6,3,5,null,2,0,null,null,1]

        int[] nums2 = {3,2,1};
        TreeNode root2 = sol.constructMaximumBinaryTree(nums2);
    }
}