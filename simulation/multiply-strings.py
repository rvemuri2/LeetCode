class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        n1, n2 = 0, 0
        for i in range(len(num1)):
            n = ord(num1[i]) - 48
            n1 = n1*10 + n

        for i in range(len(num2)):
            n = ord(num2[i]) - 48
            n2 = n2*10 + n
        
        return str(n1 * n2)