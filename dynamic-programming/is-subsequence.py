class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:

        l = 0
        r = 0
        count = 0

        if(len(s) == 0 and len(t) > 0):
            return True
        
        if(len(s) == 0 and len(t) == 0):
            return True

        while(l < len(s) and r < len(t)):

            if(s[l] == t[r]):
                l += 1
                count += 1
            
            r += 1
        
        if(count == len(s)):
            return True
        else:
            return False
        