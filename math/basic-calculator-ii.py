class Solution:
    def calculate(self, s: str) -> int:

        i = 0

        curr = 0
        res = 0
        prev = 0

        op = "+"

        while(i < len(s)):
            cur_char = s[i]

            if(cur_char.isdigit()):
                while(i < len(s) and s[i].isdigit()):
                    curr = curr * 10 + int(s[i]) 
                    i+=1
                
                i-=1
                if(op == "+"):
                    res += curr

                    prev = curr
                
                elif(op == "-"):
                    res -= curr

                    prev = -curr
                elif(op == "*"):
                    res -= prev
                    res += prev * curr

                    prev = curr * prev
                
                elif(op == "/"):
                    res -= prev
                    res += int(prev / curr)

                    prev = int(curr / prev)
            
                curr = 0
            
            elif(cur_char != " "):
                op = cur_char
            
            i+=1
        
        return res


            




        