# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue = deque()
        res = []

        
        queue.append(root)

        while len(queue) > 0:
            level = []
            for i in range(len(queue)):
                curr = queue.popleft()
                if root:
                    level.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            if(level):
                res.append(level)
        
        return res