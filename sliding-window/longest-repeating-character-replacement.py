class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        h = {}

        L = 0
        ans = 0

        for R in range(len(s)):
            h[s[R]] = h.get(s[R], 0) + 1

            if((R - L + 1) - max(h.values()) > k):
                h[s[L]] -= 1
                L += 1
            
            ans = max(ans, R - L + 1)
    
        return ans