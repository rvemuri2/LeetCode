class Solution:
    def calculate(self, s: str) -> int:

        i = 0

        curr = 0
        arr = []

        op = "+"

        for i in range(len(s)):

            curr_ch = s[i] 

            if (curr_ch.isdigit()):
                curr = curr * 10 + int(curr_ch)
            
            if (not curr_ch.isdigit() and curr_ch != ' ') or i == len(s) - 1:

                if(op == "+"):
                    arr.append(curr)      
            
                elif(op == "-"):
                    arr.append(-curr)
            
                elif(op == "*"):
                    arr[-1] *= curr

                elif(op == "/"):
                    arr[-1] = int(arr[-1] / curr)

        
                curr = 0
                op = curr_ch
        
        return sum(arr)


            




        