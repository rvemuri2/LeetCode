class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:

        L = 0

        window = 0
        length = float('inf')

        for R in range(len(nums)):

            window += nums[R]
            while(window >= target):
                length = min(length, (R - L + 1))
                window -= nums[L]
                L += 1
            

        
        if length == float('inf'):
            return 0
        else:
            return length


        