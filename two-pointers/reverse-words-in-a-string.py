class Solution:
    def reverseWords(self, s: str) -> str:

        s = s.split()

        str1 = ""

        arr = deque()

        for i in range(len(s)):
            if(i > 0):
                arr.appendleft(s[i] + " ")
            else:
                arr.appendleft(s[i])
        
        for i in arr:
            str1 += i
        
        
        return str1
        