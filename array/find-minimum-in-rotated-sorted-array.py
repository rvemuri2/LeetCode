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
            mid = (l + r) // 2
            if(nums[l] < nums[r]):
                return nums[l]

            result = min(result, mid)

            if(nums[mid] >= nums[l]):
                l = mid + 1
            else:
                r = mid - 1
        
        return nums[result]
        