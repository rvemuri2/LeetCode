class Solution:
    def rotate(self, nums: List[int], k: int) -> None:

        while(k > 0):

            var = nums[len(nums) - 1]
            nums.insert(0, var)
            nums.pop()
            k -= 1
        