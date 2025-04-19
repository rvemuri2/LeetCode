class Solution:
    def countFairPairs(self, nums, lower, upper):
   
        nums.sort()

        left, right = 0, len(nums) - 1
        count_within_upper = 0

        while left < right:
            if nums[left] + nums[right] <= upper:
                count_within_upper += (right - left)
                left += 1
            else:
                right -= 1

        left = 0
        right = len(nums) - 1
        count_below_lower = 0
        
        while left < right:
            if nums[left] + nums[right] < lower:
                count_below_lower += (right - left)
                left += 1
            else:
                right -= 1
                
        return count_within_upper - count_below_lower