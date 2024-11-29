class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        rows = len(matrix)
        columns = len(matrix[0])

        top = 0
        bottom = rows - 1

        #Get the correct row to implement binary search
        while(top <= bottom):
            mid = (top + bottom) // 2

            if target > matrix[mid][-1]:
                top = mid + 1
            elif target < matrix[mid][0]:
                bottom = mid - 1
            else:
                break
            
        
        if not (top <= bottom):
            return False
        
        row = (top + bottom) // 2
        
        #now do binary search on the exact row

        left = 0
        right = columns - 1

        while(left <= right):
            mid = (left + right) // 2

            if(target == matrix[row][mid]):
                return True
            elif(target > matrix[row][mid]):
                left = mid + 1
            else:
                right = mid - 1
        
        return False







        