class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:

        arr = []

        for i in range(len(nums)):
            nums[i] = abs(nums[i])

        for i in range(len(nums)):

            if(-1 * nums[i] in nums):
                arr.append(nums[i])
            
            nums[i] = -1 * nums[i]
        
        return arr
        