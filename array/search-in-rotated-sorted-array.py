class Solution:
    def search(self, nums: List[int], target: int) -> int:

        l = 0
        r = len(nums) - 1

        while(l <= r):

            mid = (r + l) // 2
            if(target == nums[mid]):
                return mid

            if(nums[l] <= nums[r]):
                if(target == nums[mid]):
                    return mid
                elif(target > nums[mid]):
                    l = mid + 1
                else:
                    r = mid - 1
            
            if(nums[mid] >= nums[l]):
                if(target > nums[mid] or target < nums[l]):
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                r = mid - 1

        return -1