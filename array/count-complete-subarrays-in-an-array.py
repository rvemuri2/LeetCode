class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:

        total_distinct = len(set(nums))
        count = 0
        n = len(nums)

        for i in range(n):
            freq = defaultdict(int)
            distinct = 0

            for j in range(i, n):
                if freq[nums[j]] == 0:
                    distinct += 1
                freq[nums[j]] += 1

                if distinct == total_distinct:
                    count += 1

        return count
        