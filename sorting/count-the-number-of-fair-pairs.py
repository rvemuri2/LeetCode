class Solution:
    def countFairPairs(self, nums, lower, upper):
        # Step 1: Sort the input array in ascending order.
        # Sorting is crucial because it allows us to efficiently count valid pairs using the two-pointer technique.
        nums.sort()

        # Initialize two pointers for counting pairs where the sum is less than or equal to `upper`.
        left = 0
        right = len(nums) - 1
        count_within_upper = 0
        
        # Step 2: Count pairs where the sum is less than or equal to the upper bound.
        # The two-pointer approach works by checking if the sum of `nums[left] + nums[right]` is within the upper bound.
        # If the sum is within bounds, all pairs (nums[left], nums[i]) where left < i < right are valid, so we count them.
        while left < right:
            if nums[left] + nums[right] <= upper:
                # If the current pair is valid, then all the pairs from left to right-1 are also valid.
                # We count the number of such pairs: (nums[left], nums[left+1]...), (nums[left], nums[right])
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