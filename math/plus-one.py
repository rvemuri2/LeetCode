class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        String = ''
        for i in digits:
            String += str(i)
        Val = int(String)+1;Val = str(Val)
        Result = []
        for i in Val:
            Result.append(int(i))
        return Result 
        