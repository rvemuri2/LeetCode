class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:

        right = k
        left = 0
        avg = float('-inf')

        while(right < len(nums)):
            total = 0
            for i in range(k):
                total += nums[i]
            total /= k
            avg = max(avg, total)
            right += 1
            left += 1
        
        return avg
        