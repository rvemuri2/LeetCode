class Solution:
    def removeStars(self, s: str) -> str:

        s.split()
        arr = []
        print(s)
        for i in s:

            print(i)

            if(i == "*"):

                arr.pop()
            
            else:
                arr.append(i)
        
        print(arr)
        return "".join(arr)
        