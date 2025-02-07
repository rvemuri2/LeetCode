class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numsList = {}
        for i,n in enumerate(nums):
            if target - n in numsList:
                return [numsList[target - n], i]
            else:
                numsList[n] = i


        