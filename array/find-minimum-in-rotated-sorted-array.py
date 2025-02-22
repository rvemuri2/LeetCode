class Solution:
    def findMin(self, nums: List[int]) -> int:

        l = 0
        r = len(nums) - 1
        idx = -1
    
    
        while(l <= r):
            mid = (l + r) // 2
            if(nums[mid] <= nums[-1]):
                idx = mid
                r = mid - 1
            else:
                l = mid + 1
        
        
        return nums[mid]
 


        