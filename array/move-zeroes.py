class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        l = 0

        for i in range(1, len(nums)):

            if(nums[l] == 0 and nums[i] != 0):
                nums[l], nums[i] = nums[i], nums[l]
                l += 1
            
            if(nums[l] != 0 and nums[i] == 0):
                l += 1
            
            if(nums[l] != 0 and nums[i] != 0):
                l += 1
            
        