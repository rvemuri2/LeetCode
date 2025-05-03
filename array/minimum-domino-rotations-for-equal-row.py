from typing import List

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        
        def check(x):
            """
            Check if we can make all tops or all bottoms equal to x.
            Return the minimum rotations needed, or float('inf') if impossible.
            """
            rotations_top = 0     # Rotations to make all tops = x
            rotations_bottom = 0  # Rotations to make all bottoms = x

            for i in range(len(tops)):
                if tops[i] != x and bottoms[i] != x:
                    return float('inf')  # Can't make either top or bottom = x

                elif tops[i] != x:
                    rotations_top += 1  # Must rotate to bring x to top

                elif bottoms[i] != x:
                    rotations_bottom += 1

            return min(rotations_top, rotations_bottom)
        
        rotations = min(check(tops[0]), check(bottoms[0]))
        
        return -1 if rotations == float('inf') else rotations
