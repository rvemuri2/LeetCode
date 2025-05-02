from typing import List

class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        # Initialize an empty list to store the result
        ans = []

        for i in range(len(nums)):
            value = nums[nums[i]]  
            ans.append(value)

        return ans

        