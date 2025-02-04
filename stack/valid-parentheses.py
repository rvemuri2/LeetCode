class Solution:
    def isValid(self, s: str) -> bool:

        h = {")": "(", "}": "{", "]": "["}

        arr = []


        for i in s:

            if(len(arr) == 0 and i in h):
                return False
            
            if(i == '(' or i == '[' or i == '{'):
                arr.append(i)
            
            if(i in h):
                
                if(arr[-1] != h[i] and len(arr) > 0):
                    return False
                
                if(arr[-1] == h[i]):
                    arr.pop()
        
        return True if len(arr) == 0 else False


        