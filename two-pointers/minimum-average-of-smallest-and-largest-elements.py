class Solution:
    def minimumAverage(self, nums: List[int]) -> float:
        
        averages = []
        nums = sorted(nums)
        
        while len(nums) > 1:
            num1 = nums.pop(0)
            num2 = nums.pop(-1)
            averages.append((num1 + num2) / 2)
        
        return min(averages)




        