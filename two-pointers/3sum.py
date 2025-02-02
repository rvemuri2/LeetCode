class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        res = []
        nums.sort()

        for i, j in enumerate(nums):

            if(i > 0 and j == nums[i - 1]):
                continue
            
            l = i + 1
            r = len(nums) - 1

            while(l < r):
                sum1 = nums[l] + nums[r] + j
                if(sum1 > 0):
                    r -= 1
                if(sum1 < 0):
                    l += 1
                if(sum1 == 0):
                    res.append([nums[r], nums[l], j])
                    l += 1
                    while(nums[l] == nums[l - 1] and l < r):
                        l += 1
        
        return res
            

        