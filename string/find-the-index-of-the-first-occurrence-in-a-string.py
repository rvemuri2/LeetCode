class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        l = len(needle)
        r = 0
        for i in range(len(haystack)):
            
            if(haystack[i:l] == needle):
                return r

            l += 1
        
        return -1
        