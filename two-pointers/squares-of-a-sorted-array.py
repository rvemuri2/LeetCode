class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:

        l = 0
        r = len(nums) - 1
        arr = []

        while(l <= r):

            if(abs(nums[r]) > abs(nums[l])):

                arr.insert(0, nums[r] * nums[r])
                r -= 1
            
            else:
                arr.insert(0, nums[l] * nums[l])
                l += 1
            
        return arr
        