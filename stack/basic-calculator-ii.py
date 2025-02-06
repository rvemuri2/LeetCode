class Solution:
    def calculate(self, s: str) -> int:

        i = 0

        curr = 0
        arr = []

        op = "+"

        for i in range(len(s)):

            if (s[i].isdigit()):
                curr = curr * 10 + int(s[i])
            
            if (not s[i].isdigit() and s[i] != ' ') or i == len(s) - 1:

                if(op == "+"):
                    arr.append(curr)      
            
                elif(op == "-"):
                    arr.append(-curr)
            
                elif(op == "*"):
                    arr[-1] *= curr

                elif(op == "/"):
                    arr[-1] = int(arr[-1] / curr)

        
                curr = 0
                op = s[i]
        
        return sum(arr)


            




        