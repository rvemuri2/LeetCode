class Solution:
    def judgeCircle(self, moves: str) -> bool:

        arr = [0, 0]

        for i in moves:

            if(i == "U"):

                arr[1] += 1
            
            if(i == "D"):

                arr[1] -= 1
            
            if(i == "R"):

                arr[0] += 1
            
            if(i == "L"):
                arr[0] -= 1
        
        return arr == [0, 0]
        