class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:

        min_length = float('inf')
        sum1 = 0

        l = 0
        r = 0

        while(r < len(nums)):

            sum1 += nums[r]
            r += 1

            while(sum1 >= target):
                min_length = min(min_length, r - l)
                sum1 -= nums[l]
                count -= 1
                l += 1
            
        return 0 if min_length == float('inf') else min_length
        