class Solution:
    def maxArea(self, height: list[int]) -> int:
        start = 0
        end = len(height) - 1
        area = 0

        while(start < end):
            width = end - start
            area = max(area, min(height[start], height[end]) * width)
            if(height[start] > height[end]):
                end -= 1
            elif(height[start] < height[end]):
                start += 1
            else:
                end -= 1
                start += 1
        
        return area