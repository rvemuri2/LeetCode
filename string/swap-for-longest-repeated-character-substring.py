class Solution:
    def maxRepOpt1(self, text: str) -> int:

        h = {}

        for i in text:
            h[i] = h.get(i, 0) + 1
        
        return max(h.values())
    
        