class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        left = 0
        right = len(nums)-1
        first_pos, last_pos = -1, -1
 
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                first_pos = mid
                right = mid - 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
    
        left = 0
        right = len(nums)-1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                last_pos = mid
                left = mid+1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return [first_pos, last_pos]
                
                
                
        