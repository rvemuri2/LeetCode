class Solution:
    def maxSubArray(self, nums: List[int]) -> int:

        total_max = nums[0]
        current_sum = nums[0]

        for i in range(1, len(nums)):

            current_sum = max(nums[i], current_sum + nums[i])
            total_max = max(total_max, current_sum)

        return total_max

        