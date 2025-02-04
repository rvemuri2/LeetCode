class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:

        h = set(nums)

        if(len(nums) == len(h)):
            return False
        else:
            return True
        