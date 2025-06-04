class Solution:
    def findMin(self, nums: List[int]) -> int:

        l = 0
        r = len(nums) - 1
        idx = nums[0]
    
    
        while(l <= r):
            mid = (l + r) // 2
            if(nums[l] < nums[r]):
                idx = min(idx, nums[l])
                break
            idx = min(idx, nums[mid])
            if(nums[mid] >= nums[l]):
                l = mid + 1
            else:
                r = mid - 1
        
        return idx
 


        