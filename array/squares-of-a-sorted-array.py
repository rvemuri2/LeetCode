class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:

        squaredArray = []
        left = 0
        right = len(nums) - 1

        while(left <= right):

            leftval = nums[left] * nums[left]
            rightval = nums[right] * nums[right]
            squaredArray.append(max(leftval, rightval))

            if(leftval >= rightval):
                left += 1
            else:
                right -= 1
        
        return squaredArray[::-1]
        