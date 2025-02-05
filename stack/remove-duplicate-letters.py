class Solution:
    def removeDuplicateLetters(self, s: str) -> str:

        h = {}

        for i in range(len(s)):
            h[s[i]] = i
        
        arr = []
        seen = set()

        for i in range(len(s)):
            if s[i] not in seen:
                while(arr and arr[-1]>s[i] and h[arr[-1]] > i):
                    seen.remove(arr[-1])
                    arr.pop()

                arr.append(s[i])
                seen.add(s[i])
        
        return "".join(arr)
            
        