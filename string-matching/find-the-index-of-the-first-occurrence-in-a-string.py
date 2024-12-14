class Solution:
    def strStr(self, haystack: str, needle: str) -> int:

        l = len(needle)
        r = 0
        while(r < len(haystack) and l < len(haystack)):

            if(haystack[r:l] == needle):
                return r

            r += 1
        
        return -1
        