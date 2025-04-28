class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        total = current_sum = count = left = 0

        for right in range(n):
            current_sum += nums[right]

            while left <= right and current_sum * (right - left + 1) >= k:
                current_sum -= nums[left]
                left += 1

            count += right - left + 1

        return count
        