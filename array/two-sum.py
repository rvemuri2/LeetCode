class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        map1 = {}

        for i, val in enumerate(nums):

            if(target - val in map1):
                return [map1[target - val], i]

            
            map1[val] = i

            

        