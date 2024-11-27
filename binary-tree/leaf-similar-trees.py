# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:

        arr1 = []
        arr2 = []

        def dfs(root, leafArr):

            if not root:
                return None
            if not root.left and not root.right:
                leafArr.append(root.val)
                return
            
            dfs(root.left, leafArr)
            dfs(root.right, leafArr)
        
        dfs(root1, arr1)
        dfs(root2, arr2)

        return arr1 == arr2
       
        

        