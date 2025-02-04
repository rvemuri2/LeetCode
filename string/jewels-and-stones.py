class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:

        count = 0

        c = Counter(jewels)

        for i in stones:

            if i in c:
                count += 1
        
        return count
        