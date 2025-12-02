class Solution:
    def isPalindrome(self, s: str) -> bool:
        str1 = ""
        for i in s:
            if(i.isalnum()):
                i = i.lower()
                str1 += i
        
        left = 0
        right = len(s) - 1

        while(left < right):

            if(not (s[left].isalnum())):
                left += 1
            elif(not (s[right].isalnum())):
                right -= 1
            elif(s[left].lower() == s[right].lower()):
                left += 1
                right -= 1
            else:
                return False

        return True        