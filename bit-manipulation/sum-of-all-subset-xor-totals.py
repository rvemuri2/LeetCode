class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        t=0
        for i in nums:
            t|=i
        return t*(2**(len(nums)-1))