class Solution:
    def maxArea(self, height: List[int]) -> int:

        max1 = 0

        i = 0
        j = len(height) - 1

        while (i < j):

            minHeight = min(height[i], height[j])
            area = (j - i) * minHeight
            max1 = max(max1, area)

            if(height[i] < height[j]):
                i += 1
            else:
                j -= 1

        return max1
        