class Solution:
    def countLargestGroup(self, n: int) -> int:
        return list((c := Counter(sum(map(int, str(i))) for i in range(1, n+1))).values()).count(max(c.values()))