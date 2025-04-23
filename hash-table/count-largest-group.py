class Solution:
    def countLargestGroup(self, n: int) -> int:
        # Solution 2: one-liner
        return list((c := Counter(sum(map(int, str(i))) for i in range(1, n+1))).values()).count(max(c.values()))