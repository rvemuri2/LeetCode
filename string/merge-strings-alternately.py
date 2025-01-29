class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:

        l = 0
        r = 0

        str1 = ""

        while(l < len(word1) and r < len(word2)):

            str1 += word1[l]
            str1 += word2[r]
        
            l+=1
            r+=1
        
        if(l == len(word1) and r < len(word2)):
            str1 += word2[r:]
        
        if(r == len(word2) and l < len(word1)):
            str1 += word1[l:]


        return str1
        