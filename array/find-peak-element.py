class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        l = 0
        r = len(nums) - 1
        idx = 0

        while(l <= r):

            mid = (l + r) // 2

            if(nums[mid] > nums[mid + 1] and nums[mid] > nums[mid - 1]):
                idx = mid
                r -= 1
            
            else:
                l += 1

        return idx
        