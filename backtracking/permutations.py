class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        res = []

        def dfs(curr):

            if(len(curr) == len(nums)):
                res.append(curr.copy())
                return 
            
            for i in nums:
                if i not in curr:
                    curr.append(i)
                    dfs(curr)
                    curr.pop()

        dfs([])
        return res


        