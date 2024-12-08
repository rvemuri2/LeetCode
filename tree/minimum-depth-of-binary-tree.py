# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:

        self.min = float('inf')

        def dfs(root, num):

            if not root:
                return 0
            
            if not root.left and not root.right:
                self.min = min(self.min, num)

            dfs(root.left, 1 + num)
            dfs(root.right, 1 + num)

        dfs(root, 1)
        return self.min
        