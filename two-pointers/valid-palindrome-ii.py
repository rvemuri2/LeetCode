class Solution:
    def validPalindrome(self, s: str) -> bool:

        l = 0
        r = len(s) - 1

        count = 0

        while(l < r):

            if(s[l] != s[r] and count == 0):
                count += 1
                r -= 1

            if(s[l] != s[r] and count >= 1):
                return False
            
            if(s[l] == s[r]):
                l+=1
                r-=1
            
        
        return True

        