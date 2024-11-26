# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def dfs(left, right):

            if not left and not right:
                return True
            
            if not left and right:
                return False
            
            if not right and left:
                return False
            
            if left.val != right.val:
                return False
            
            return dfs(left.left, right.right)
        
        return dfs(root.left, root.right)

        # if not root:
        #     return True
        
        # if root.right != root.left:
        #     return False
        
        # if root.right == root.left:
        #     return True

        # # left = self.isSymmetric(root.left)
        # # right = self.isSymmetric(root.right)
    
        # return self.isSymmetric(root.left) and self.isSymmetric(root.right)

        
        