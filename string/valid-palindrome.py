class Solution:
    def isPalindrome(self, s: str) -> bool:
        str1 = ""
        for i in s:
            if(i.isalnum()):
                i = i.lower()
                str1 += i
        
        left = 0
        right = len(str1) - 1

        while(left < right):
            if(str1[left] != str1[right]):
                return False
            left += 1
            right -= 1

        return True        