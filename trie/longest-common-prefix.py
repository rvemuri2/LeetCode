class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:

        res = ""

        for i in range(len(strs[0])):

            for k in strs[1:]:
                if(i == len(k) or strs[0][i] != k[i]):
                    return res
            
            res += strs[0][i]
        
        return res




        