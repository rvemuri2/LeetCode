class Solution:
    def longestPalindrome(self, s: str) -> int:

        l = defaultdict(int)
        res = 0

        for i in s:
            l[i] += 1
            if(l[i] % 2 == 0):
                res += 2
        
        for i in l.values():
            if(i % 2):
                res += 1
                break
        
        return res
        