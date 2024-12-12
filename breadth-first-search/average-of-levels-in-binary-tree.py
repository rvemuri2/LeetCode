# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:

        q = deque([root])

        res = []

        while(q):
            level = []
            for i in range(len(q)):
                curr = q.popleft()
                if(curr):
                    level.append(curr.val)
                    q.append(curr.left)
                    q.append(curr.right)
            if(level):
                res.append(sum(level) / len(level))
        
        return res