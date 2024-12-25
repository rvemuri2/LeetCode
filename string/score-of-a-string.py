class Solution:
    def scoreOfString(self, s: str) -> int:

        i = 0
        j = 1

        sum1 = 0
        while(j < len(s)):

            sum1 += abs(ord(s[i]) - ord(s[j]))
            i += 1
            j += 1
        
        return sum1
        