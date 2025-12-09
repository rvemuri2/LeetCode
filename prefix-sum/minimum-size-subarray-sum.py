class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:

        count = 0
        min_length = float('inf')
        sum1 = 0

        for i in nums:
            sum1 += i
            count += 1
            if(sum1 >= target):
                min_length = min(count, min_length)
                sum1 = i
                count = 1

        return 0 if min_length == float('inf') else min_length
        