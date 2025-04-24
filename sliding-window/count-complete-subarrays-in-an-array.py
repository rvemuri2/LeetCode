class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:

        total_distinct = len(set(nums))
        n = len(nums)

        def count_at_most_k(k):
            freq = defaultdict(int)
            left = 0
            res = 0

            for right in range(n):
                freq[nums[right]] += 1

                while len(freq) > k:
                    freq[nums[left]] -= 1
                    if freq[nums[left]] == 0:
                        del freq[nums[left]]
                    left += 1

            # number of subarrays ending at `right
                res += right - left + 1

            return res

    # Complete subarrays
        return count_at_most_k(total_distinct) - count_at_most_k(total_distinct - 1)