class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:

        l = 0
        r = 0
        count = 0

        if(str1 == str2):
            return True

        while(l < len(str1) and r < len(str2)):

            if(ord(str1[l]) - ord(str2[r]) == -1 or ord(str1[l]) - ord(str2[r]) == 25):
                l += 1
                r += 1
            elif(str1[l] == str2[r]):
                l += 1
                r += 1
            else:
                l += 1

        if r > len(str2) - 1:
            return True
        else:
            return False



        