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

            # Calculate the new sum for the current node
            current_sum = current_sum * 10 + node.val

            # If the node is a leaf, add the current sum to the total
            if not node.left and not node.right:
                self.total_sum += current_sum
                return self.total_sum

            # Recur for the left and right subtrees
            dfs(node.left, current_sum)
            dfs(node.right, current_sum)
        
        # Start DFS from the root
        dfs(root, 0)
        
        return self.total_sum