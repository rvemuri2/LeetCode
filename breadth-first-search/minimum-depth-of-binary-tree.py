# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:

        q = deque([root])

        if not root:
            return 0

        level = 0
        while(q):
            level += 1
            for i in range(len(q)):
                curr = q.popleft()
                if(not curr.right and not curr.left):
                    return level
                if(curr.left):
                    q.append(curr.left)
                if(curr.right):
                    q.append(curr.right)
        
        return level