# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:

        self.nodes = 0

        def dfs(root):

            if not root:
                return
            
            self.nodes += 1
            dfs(root.left)
            dfs(root.right)

        dfs(root)
        return self.nodes
        