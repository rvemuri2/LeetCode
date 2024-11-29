class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:

        low = 1
        high = max(piles)
        res = high

        while(low <= high):

            k = (high + low) // 2
            hours = 0
            for i in piles:
                hours += math.ceil(i / k)

            if(hours <= h):
                res = min(res, k)
                high = k - 1
            else:
                low = k + 1
            
        return res
        