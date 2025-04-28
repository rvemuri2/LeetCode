class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        left = 0
        total = 0
        current_sum = 0
        count = 0

        for right in range(n):
            current_sum += nums[right]

        # While score >= k
            while left <= right and current_sum * (right - left + 1) >= k:
                current_sum -= nums[left]
                left += 1

            count += right - left + 1

        return count
        