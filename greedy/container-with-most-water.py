class Solution:
    def maxArea(self, height: list[int]) -> int:
        start = 0
        end = len(height) - 1
        area = 0

        while(start < end):
            width = end - start
            if(height[start] > height[end]):
                area = max(area, height[end] * width)
                end -= 1
            elif(height[start] < height[end]):
                area = max(area, height[start] * width)
                start += 1
            else:
                area = max(area, height[end] * width)
                end -= 1
        
        return area