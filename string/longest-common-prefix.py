class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:


        for i in range(len(strs[0])):

            for k in range(1, len(strs)):
                if(i == len(strs) or strs[0][i] != strs[k][i]):
                    return strs[0][:i]
            
        return strs[0]
        



        