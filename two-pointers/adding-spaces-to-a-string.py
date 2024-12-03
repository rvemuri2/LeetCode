class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:

        res = ""

        s_index = 0

        count = 0

        while(s_index < len(spaces)):     

            if(count == spaces[s_index]):
                res += " "
                s_index += 1

            res += s[count]
            
            count += 1
        
        if count < len(s):
            res += s[count:]
        return res


        