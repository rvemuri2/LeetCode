# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSubtree(self, root, subRoot):
       
        if not subRoot:
            return True
            
        if not root:
            return False

        if self.sameTree(root, subRoot):
            return True
            
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
        
        
    def sameTree(self, p, q):
        if not p and not q:
            return True
            
        if not p and q:
            return False
            
        if not q and p:
            return False
            
        if p.val != q.val:
            return False
            
        return self.sameTree(p.left, q.left) and self.sameTree(p.right, q.right)
        