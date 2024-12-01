class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        rows, columns = len(matrix) - 1, len(matrix[0])

        top = 0
        bottom = rows

        while(top <= bottom):

            row = (top + bottom) // 2

            if(target < matrix[row][0]):
                bottom = row - 1
            
            elif(target > matrix[row][-1]):
                top = row + 1
            
            else:
                break
        
        left = 0
        right = columns - 1

        while(left <= right):
            
            mid = (left + right) // 2

            if(target > matrix[row][mid]):
                left = mid + 1
            
            elif(target < matrix[row][mid]):
                right = mid - 1
            
            else:
                return True
        
        return False
        
        