class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        permutations = [[]]

        for n in nums:
            new_permutations = []
            for p in permutations:
                for i in range(len(p) + 1):
                    p_copy = p.copy()
                    p_copy.insert(i, n)
                    new_permutations.append(p_copy)

            permutations = new_permutations
        return permutations


        