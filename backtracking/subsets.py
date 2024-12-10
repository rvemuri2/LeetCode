class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        res = []

        curr = []

        def dfs(index):
            if index >= len(nums):
                res.append(curr.copy())
                return
            
            #decision to include nums[i]
            curr.append(nums[index])
            dfs(index + 1)

            #decision to not include nums[i]
            curr.pop()
            dfs(index + 1)
        
        dfs(0)
        return res

        