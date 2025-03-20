class Solution:

    def __init__(self):
        self.ns = {1: 1, 2: 2}

    def climbStairs(self, n: int) -> int:
        if n not in self.ns:
            self.ns[n] = self.climbStairs(n-1) + self.climbStairs(n-2)
        return self.ns[n]