class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        ans = 0

        for i in range(n):
            current_max = nums[i]
            max_count = 1  # At least 1 occurrence of nums[i]

            for j in range(i+1, n):
                if nums[j] > current_max:
                    current_max = nums[j]
                    max_count = 1  # Reset counter for new maximum
                elif nums[j] == current_max:
                    max_count += 1

                if max_count >= k:
                    ans += 1

            # Check single-element subarray separately
            if k == 1:
                ans += 1

        return ans