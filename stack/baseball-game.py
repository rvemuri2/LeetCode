class Solution:
    def calPoints(self, operations: List[str]) -> int:

        arr = []

        for i in operations:

            if(i != "C" and i != "D" and i != "+"):
                arr.append(int(i))
            
            if(i == "C"):
                arr.pop()
            
            if(i == "D"):
                num = arr[-1]
                arr.append(num * 2)
            
            if(i == "+"):
                num = arr[-1]
                num2 = arr[-2]
                arr.append(num + num2)
        
        return sum(arr)
        