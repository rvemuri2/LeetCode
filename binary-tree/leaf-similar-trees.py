# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:

        def dfs(left, right):

            if not left and not right:
                return True
        
            if not left and right:
                return False
        
            if not right and left:
                return False

            if not left.left and not left.right and not right.left and not right.right and left.val == right.val:
                return True
            
            if not left.left and not left.right and not right.left and not right.right and left.val != right.val:
                return False
            
            return dfs(left.left, right.left) or dfs(left.right, right.right)
        
        return dfs(root1, root2)
       
        

        