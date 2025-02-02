class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        count = 0
        res = 0

        for i in nums:

            if(count == 0):
                res = i
            
            count += (1 if i == res else -1)
        
        return res

        
        