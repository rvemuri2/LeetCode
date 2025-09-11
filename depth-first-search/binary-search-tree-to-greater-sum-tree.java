
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        int acc = 0;
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.right;
            }
            TreeNode node = st.pop();
            acc += node.val;
            node.val = acc;
            cur = node.left;
        }
        return root;
    }
}
