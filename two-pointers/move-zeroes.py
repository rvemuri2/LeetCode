class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        l = 0
        r = 1

        while(r < len(nums) and l < len(nums)):
            if(nums[l] == 0 and nums[r] == 0):
                r += 1
                if(r >= len(nums)):
                    break
            
            if(nums[l] == 0 and nums[r] != 0):
                nums[l], nums[r] = nums[r], nums[l]
                r += 1
                l += 1
        
        return nums
        