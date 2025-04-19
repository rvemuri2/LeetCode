class Solution:
    def countFairPairs(self, nums, lower, upper):
        # Step 1: Sort the input array in ascending order.
        # Sorting is crucial because it allows us to efficiently count valid pairs using the two-pointer technique.
        nums.sort()

        # Initialize two pointers for counting pairs where the sum is less than or equal to `upper`.
        left = 0
        right = len(nums) - 1
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