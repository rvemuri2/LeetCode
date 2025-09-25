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
    // ----- Solution from previous message -----
    static class Solution {
        public TreeNode balanceBST(TreeNode root) {
            ArrayList<Integer> vals = new ArrayList<>();
            inorder(root, vals);
            return build(vals, 0, vals.size() - 1);
        }

        private void inorder(TreeNode node, List<Integer> vals) {
            if (node == null) return;
            inorder(node.left, vals);
            vals.add(node.val);
            inorder(node.right, vals);
        }

        private TreeNode build(List<Integer> vals, int l, int r) {
            if (l > r) return null;
            int m = l + (r - l) / 2;
            TreeNode root = new TreeNode(vals.get(m));
            root.left  = build(vals, l, m - 1);
            root.right = build(vals, m + 1, r);
            return root;
        }
    }

    // ----- Utilities: build/print/verify -----

    // Build a tree from a level-order array with nulls (e.g., [1,null,2,null,3,...])
    static TreeNode buildLevelOrder(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();
            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                q.add(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    // Serialize to level-order (trim trailing nulls for nicer display)
    static List<Integer> toLevelOrder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                out.add(null);
                continue;
            }
            out.add(cur.val);
            q.add(cur.left);
            q.add(cur.right);
        }
        // trim trailing nulls
        int last = out.size() - 1;
        while (last >= 0 && out.get(last) == null) last--;
        return out.subList(0, last + 1);
    }

    // Check if (sub)tree is height-balanced
    static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    static int height(TreeNode n) {
        if (n == null) return 0;
        int lh = height(n.left);
        if (lh == -1) return -1;
        int rh = height(n.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    // Inorder list (should be sorted if it’s a BST)
    static List<Integer> inorderVals(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) { st.push(cur); cur = cur.left; }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    // ----- Tests -----
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1:
        // Input: [1,null,2,null,3,null,4,null,null]
        // (Right-skewed chain 1->2->3->4)
        TreeNode ex1 = buildLevelOrder(new Integer[]{1, null, 2, null, 3, null, 4});
        TreeNode ex1Balanced = sol.balanceBST(ex1);
        System.out.println("Example 1:");
        System.out.println("  Before (level): " + toLevelOrder(ex1));
        System.out.println("  After  (level): " + toLevelOrder(ex1Balanced));
        System.out.println("  Inorder sorted: " + inorderVals(ex1Balanced));
        System.out.println("  Is balanced?   " + isBalanced(ex1Balanced));
        System.out.println();

        // Example 2:
        TreeNode ex2 = buildLevelOrder(new Integer[]{2, 1, 3});
        TreeNode ex2Balanced = sol.balanceBST(ex2);
        System.out.println("Example 2:");
        System.out.println("  Before (level): " + toLevelOrder(ex2));
        System.out.println("  After  (level): " + toLevelOrder(ex2Balanced));
        System.out.println("  Inorder sorted: " + inorderVals(ex2Balanced));
        System.out.println("  Is balanced?   " + isBalanced(ex2Balanced));
        System.out.println();

        // Additional test: larger skewed BST 1..10 (insert in ascending order)
        TreeNode skew = null;
        for (int v = 1; v <= 10; v++) skew = insertBST(skew, v);
        TreeNode skewBalanced = sol.balanceBST(skew);
        System.out.println("Skewed 1..10:");
        System.out.println("  Before height: " + height(skew));
        System.out.println("  After  height: " + height(skewBalanced));
        System.out.println("  Inorder match: " + inorderVals(skew).equals(inorderVals(skewBalanced)));
        System.out.println("  Is balanced?   " + isBalanced(skewBalanced));
    }

    // Helper to create a BST by insertion (used in the skewed test)
    static TreeNode insertBST(TreeNode root, int v) {
        if (root == null) return new TreeNode(v);
        if (v < root.val) root.left = insertBST(root.left, v);
        else              root.right = insertBST(root.right, v);
        return root;
    }
}
What you’ll see:

Level-order lists for before/after.

Inorder traversal of the balanced tree (should be sorted and match the original multiset of values).

A balance check and heights to confirm improvement on skewed input.







You said:
Line 159: error: class, interface, enum, or record expected
}
^


ChatGPT said:
Ah, I see what happened \U0001f44d

That error (class, interface, enum, or record expected) usually means there’s an extra closing brace (}) outside of any class. In the code I gave you, the Main class already closes at the very end, but it looks like an extra } slipped in.

Here’s the fixed, complete code (just one } at the very bottom to close public class Main):

java
Copy code
import java.util.*;

/** Run this file directly: javac Main.java && java Main */
public class Main {
    // ----- LeetCode-style TreeNode -----
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int v) { val = v; }
        TreeNode(int v, TreeNode l, TreeNode r) { val = v; left = l; right = r; }
    }

    // ----- Solution -----
    static class Solution {
        public TreeNode balanceBST(TreeNode root) {
            ArrayList<Integer> vals = new ArrayList<>();
            inorder(root, vals);
            return build(vals, 0, vals.size() - 1);
        }

        private void inorder(TreeNode node, List<Integer> vals) {
            if (node == null) return;
            inorder(node.left, vals);
            vals.add(node.val);
            inorder(node.right, vals);
        }

        private TreeNode build(List<Integer> vals, int l, int r) {
            if (l > r) return null;
            int m = l + (r - l) / 2;
            TreeNode root = new TreeNode(vals.get(m));
            root.left  = build(vals, l, m - 1);
            root.right = build(vals, m + 1, r);
            return root;
        }
    }

    // ----- Utilities -----
    static TreeNode buildLevelOrder(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();
            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                q.add(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    static List<Integer> toLevelOrder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                out.add(null);
                continue;
            }
            out.add(cur.val);
            q.add(cur.left);
            q.add(cur.right);
        }
        int last = out.size() - 1;
        while (last >= 0 && out.get(last) == null) last--;
        return out.subList(0, last + 1);
    }

    static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    static int height(TreeNode n) {
        if (n == null) return 0;
        int lh = height(n.left);
        if (lh == -1) return -1;
        int rh = height(n.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    static List<Integer> inorderVals(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) { st.push(cur); cur = cur.left; }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    // ----- Tests -----
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        TreeNode ex1 = buildLevelOrder(new Integer[]{1, null, 2, null, 3, null, 4});
        TreeNode ex1Balanced = sol.balanceBST(ex1);
        System.out.println("Example 1:");
        System.out.println("  Before (level): " + toLevelOrder(ex1));
        System.out.println("  After  (level): " + toLevelOrder(ex1Balanced));
        System.out.println("  Inorder sorted: " + inorderVals(ex1Balanced));
        System.out.println("  Is balanced?   " + isBalanced(ex1Balanced));
        System.out.println();

        // Example 2
        TreeNode ex2 = buildLevelOrder(new Integer[]{2, 1, 3});
        TreeNode ex2Balanced = sol.balanceBST(ex2);
        System.out.println("Example 2:");
        System.out.println("  Before (level): " + toLevelOrder(ex2));
        System.out.println("  After  (level): " + toLevelOrder(ex2Balanced));
        System.out.println("  Inorder sorted: " + inorderVals(ex2Balanced));
        System.out.println("  Is balanced?   " + isBalanced(ex2Balanced));
        System.out.println();

        // Additional skewed test
        TreeNode skew = null;
        for (int v = 1; v <= 10; v++) skew = insertBST(skew, v);
        TreeNode skewBalanced = sol.balanceBST(skew);
        System.out.println("Skewed 1..10:");
        System.out.println("  Before height: " + height(skew));
        System.out.println("  After  height: " + height(skewBalanced));
        System.out.println("  Inorder match: " + inorderVals(skew).equals(inorderVals(skewBalanced)));
        System.out.println("  Is balanced?   " + isBalanced(skewBalanced));
    }

    // helper
    static TreeNode insertBST(TreeNode root, int v) {
        if (root == null) return new TreeNode(v);
        if (v < root.val) root.left = insertBST(root.left, v);
        else root.right = insertBST(root.right, v);
        return root;
    }
}
}