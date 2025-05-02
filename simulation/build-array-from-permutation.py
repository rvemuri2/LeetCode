from typing import List

class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        # Initialize an empty list to store the result
        ans = []

        # Iterate over each index in the input list
        for i in range(len(nums)):
            # For each index i, append nums[nums[i]] to the result list
            value = nums[nums[i]]  
            ans.append(value)

        return ans

        