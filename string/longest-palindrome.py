class Solution:
    def longestPalindrome(self, s: str) -> int:

        l = set()
        res = 0
        
        for i in s:

            if(i in l):
                l.remove(i)
                res += 2
            else:
                l.add(i)
        
        if(l):
            res += 1
            
        return res
        