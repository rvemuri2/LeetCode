class Solution:
    def evalRPN(self, tokens: List[str]) -> int:

        arr = []
        
        for i in tokens:    
            
            if(i == "+"):
                num1 = arr.pop()
                num2 = arr.pop()
                arr.append(num1 + num2)
            
            elif(i == "*"):
                num1 = arr.pop()
                num2 = arr.pop()
                arr.append(num1 * num2)
            
            elif(i == "/"):
                num1 = arr.pop()
                num2 = arr.pop()
                arr.append(int(num2 / num1))
            
            elif(i == "-"):
                num1 = arr.pop()
                num2 = arr.pop()
                arr.append(num2 - num1)
            else:
                arr.append(int(i))
        
        return arr[0]
        