class Solution:
    def fizzBuzz(self, n: int) -> List[str]:

        arr = []
        while(n > 0):

            if(n % 3 == 0 and n % 5 == 0):
                arr.append("FizzBuzz")
            
            elif(n % 5 == 0):
                arr.append("Buzz")
            
            elif(n % 3 == 0):
                arr.append("Fizz")
            
            else:
                arr.append(str(n))
            
            n -= 1
        
        return arr[::-1]