class Solution:
    def removeStars(self, s: str) -> str:

        s.split()
        arr = []
        
        for i in s:

            if(i == "*"):

                arr.pop()
            
            else:
                arr.append(i)
        
        return "".join(arr)
        