class Solution:
    def calPoints(self, operations: List[str]) -> int:

        arr = []

        for i in operations:

            if(i != "C" and i != "D" and i != "+"):
                arr.append(int(i))
            
            elif(i == "C"):
                arr.pop()
            
            elif(i == "D"):
                num = arr[-1]
                arr.append(num * 2)
            
            elif(i == "+"):
                num = arr[-1]
                num2 = arr[-2]
                arr.append(num + num2)
            
            print(arr)
        
        return sum(arr)
        