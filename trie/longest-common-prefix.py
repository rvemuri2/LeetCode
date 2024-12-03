class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:


        for i in range(len(strs[0])):

            for k in strs[1:]:
                if(i == len(k) or strs[0][i] != k[i]):              
                    return strs[0][:i]
        return strs[0]
        



        