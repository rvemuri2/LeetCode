class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:

        cur_sum = 0

        for i in range(k):
            cur_sum += nums[i]
        
        avg = cur_sum / k

        for i in range(k, len(nums)):
            cur_sum += nums[i]
            cur_sum -= nums[i - k]
            temp = cur_sum / k
            avg = max(temp, avg)
        
        return avg

        
        