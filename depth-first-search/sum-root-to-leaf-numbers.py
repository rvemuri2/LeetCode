# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        self.total_sum = 0
        
        def dfs(node, current_sum):
            if not node:
                return 0

            current_sum = current_sum * 10 + node.val

            if not node.left and not node.right:
                self.total_sum += current_sum
                return self.total_sum

            dfs(node.left, current_sum)
            dfs(node.right, current_sum)
        
        dfs(root, 0)
        
        return self.total_sum