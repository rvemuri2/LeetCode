from typing import List

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        low, mid, high = 0, 0, len(nums) - 1
        
        while mid <= high:
            if nums[mid] == 0:
                # Swap current element with low index
                nums[low], nums[mid] = nums[mid], nums[low]
                low += 1
                mid += 1
            elif nums[mid] == 1:
                # Just move on if it's 1
                mid += 1
            else:  # nums[mid] == 2
                # Swap current element with high index
                nums[mid], nums[high] = nums[high], nums[mid]
                high -= 1
