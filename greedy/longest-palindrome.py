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


        return res + 1 if l else res
        