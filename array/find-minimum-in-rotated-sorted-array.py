class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        r = len(nums) - 1
        result = 100000000000000

        while(l <= r):
            if(nums[l] < nums[r]):
                result = min(result, nums[l])
                break
            
            mid = (l + r) // 2

            result = min(result, nums[mid])

            if(nums[mid] >= nums[l]):
                l = mid + 1
            else:
                r = mid - 1
        
        return result
        