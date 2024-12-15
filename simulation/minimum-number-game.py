class Solution:
    def numberGame(self, nums: List[int]) -> List[int]:

        arr = []
        while len(nums)>0:
            alice = min(nums)
            nums.remove(min(nums))
            bob = min(nums)
            nums.remove(min(nums))
            arr.append(bob)
            arr.append(alice)
        return arr 
        