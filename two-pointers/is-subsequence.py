class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:

        l = 0
        r = 0

        if(len(s) == 0 and len(t) > 0):
            return True
        
        if(len(s) == 0 and len(t) == 0):
            return True

        while(l < len(s) - 1 and r < len(t) - 1):

            if(s[l] == t[r]):
                l += 1
            
            r += 1
        
        if(l != len(s) - 1):
            return False
        else:
            return True
        