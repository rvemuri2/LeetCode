class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:

        arr = []

        for i in range(len(nums)):

            if(-nums[i] in nums):
                arr.append(nums[i])
            
            nums[i] = -nums[i]
        
        return arr
        