class Solution:
    def singleNumber(self, nums: List[int]) -> int:

        result = 0  # Initialize result to 0. This will hold our answer.

        for num in nums:
            # XOR current number with result
            result = result ^ num

            # Explanation:
            # XOR has the following key properties:
            # 1. a ^ a = 0       -> a number XORed with itself cancels out to 0
            # 2. a ^ 0 = a       -> a number XORed with 0 remains unchanged
            # 3. XOR is commutative and associative:
            #    So the order in which you apply XOR doesn't matter

            # Applying these rules:
            # - Duplicate numbers cancel each other (e.g., 2 ^ 2 = 0)
            # - Only the number that appears once will remain (since it has no pair to cancel it)

        return result

        