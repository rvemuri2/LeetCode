class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:

        total = 0
        count = float('inf')

        for i in range(l, r + 1):

            total = sum(nums[:i])

            if(total > 0):
                count = min(count, total)
            
            for j in range(i, len(nums)):
                total += nums[j]
                total -= nums[j - i]

                if total > 0:
                    count = min(total, count)
        
        return -1 if count == float('inf') else count
        