class Solution:
    def findMin(self, nums: List[int]) -> int:

        l = 0
        r = len(nums) - 1
        idx = float('infinity')
    
        while(l <= r):
            mid = (l + r) // 2
            if(nums[mid] <= nums[-1]):
                r = mid - 1
                idx = min(idx, nums[mid])
            else:
                l = mid + 1
                idx = min(idx, nums[mid])
    
    
        return idx
 


        