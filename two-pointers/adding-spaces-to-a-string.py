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

        

        # while(s_index < len(spaces)):     

        #     if(count == spaces[s_index]):
        #         res += " "
        #         s_index += 1

        #     res += s[count]
            
        #     count += 1
        
        # if count < len(s):
        #     res += s[count:]
        # return res