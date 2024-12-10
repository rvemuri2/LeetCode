class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        res = []

        def dfs(index, curr):
            if index >= len(nums):
                res.append(curr.copy())
                return
            
            #decision to include nums[i]
            curr.append(nums[index])
            dfs(index + 1, curr)

            #decision to not include nums[i]
            curr.pop()
            dfs(index + 1, curr)
        
        dfs(0, [])
        return res

        