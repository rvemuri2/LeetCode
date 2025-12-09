class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:

        count = 0
        min_length = float('inf')
        sum1 = 0

        l = 0
        r = 0

        while(l < len(nums) and r < len(nums)):

            sum1 += nums[r]
            count += 1
            r += 1
            
            while(sum1 >= target):
                min_length = min(count, min_length)
                sum1 -= nums[l]
                count -= 1
                l += 1
            
        return 0 if min_length == float('inf') else min_length
        