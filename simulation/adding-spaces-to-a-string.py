class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:

        res = ""

        count = 0

        for i in spaces:
            res += s[count:i]
            res += " "
            count = i
        
        if count < len(s):
            res += s[count:]
        
        return res