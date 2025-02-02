class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        c = Counter(nums)
        val = 0
        k = 0
        for key, value in c.items():

            if(value > val):
                val = value
                k = key


        return k

        
        