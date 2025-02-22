class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l = 0
        r = len(nums) - 1
        bool1 = False

        while(l <= r):

            mid = (l + r) // 2

            if(nums[mid] > target):
                r = mid - 1
            
            elif(nums[mid] < target):
                l = mid + 1
            
            else:
                bool1 = True
                return mid
        
        return mid if bool1 else -1 
        