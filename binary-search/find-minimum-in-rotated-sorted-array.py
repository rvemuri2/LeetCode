class Solution:
    def findMin(self, nums: List[int]) -> int:

        l = 0
        r = len(nums) - 1
        idx = float('infinity')
    
        while(l <= r):
            mid = (l + r) // 2
            if(nums[mid] >= nums[0]):
                l = mid + 1
                idx = min(idx, nums[0])
            else:
                r = mid - 1
                idx = min(idx, nums[mid])
    
    
        return idx
 


        