class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:

        l, r = 0, len(nums) - 1

        while(l <= r):

            mid = (l + r) // 2

            if(target == nums[mid]):
                return mid
            
            elif(target > nums[mid]):

                l = mid + 1
            
            else:
                 r = mid - 1
            
        if(nums[mid] < target):
            return mid + 1
        
        else:
            return mid - 1
        