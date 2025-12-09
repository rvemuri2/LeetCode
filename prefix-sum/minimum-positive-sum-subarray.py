class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:

        left = 0
        right = 0
        total = 0
        count = float('inf')

        while(right < len(nums)):

            total += nums[right]
            right += 1

            if(total > 0 and l < (right - left + 1) <= r):
                count = min(count, total)
                total -= nums[left]
                left += 1
        
        return -1 if count == float('inf') else count
        