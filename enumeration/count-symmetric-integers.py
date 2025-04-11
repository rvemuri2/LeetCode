class Solution:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        count = 0
        for num in range(low, high+1):
            s_num = str(num)
            if len(s_num) & 1 == 0:         # or you can use % operator to check len(s_num) is even or not 
                mid = len(s_num) // 2
                if sum(map(int, s_num[:mid])) == sum(map(int, s_num[mid:])):
                    count += 1
        return count