class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        pivot=-1
        for i in range(n-2,-1,-1):
            if nums[i]<nums[i+1]:
                pivot=i
                break
        if pivot==-1: #if given permutation
            nums.reverse()
            return
        for j in range(n-1,pivot,-1):
            if nums[j]>nums[pivot]:
                nums[j], nums[pivot]=nums[pivot], nums[j]
                break
        l = pivot + 1
        r = n-1
        while l<r:
            nums[l],nums[r]=nums[r],nums[l]
            l+=1
            r-=1

        