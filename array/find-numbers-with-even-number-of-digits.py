class Solution:
    def findNumbers(self, nums: List[int]) -> int:

        count = 0
        even = 0

        for i in nums:

            while(i > 0):
                i //= 10
                count += 1
            
            if(count % 2 == 0):
                even += 1
            
            count = 0
        
        return even
        