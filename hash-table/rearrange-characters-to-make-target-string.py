class Solution:
    def rearrangeCharacters(self, s: str, target: str) -> int:

        s1 = Counter(target)
        s2 = Counter(s)

        count = float('inf')

        for i in s1.keys():
            count = min(count, s2[i] // s1[i])
        
        return count
