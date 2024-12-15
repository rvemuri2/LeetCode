class Solution:
    def minimumAverage(self, nums: List[int]) -> float: # Or raise an exception if input is invalid
        
        averages = []
        nums = sorted(nums)  # Sort the list to make min/max access easy
        
        while len(nums) > 1:
            num1 = nums.pop(0)  # Smallest number
            num2 = nums.pop(-1)  # Largest number
            averages.append((num1 + num2) / 2)
        
        return min(averages)




        