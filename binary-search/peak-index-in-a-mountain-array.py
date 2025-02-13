class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:

        l, r = 0, len(arr) - 1
        idx = float('-infinity')
    
        while(l <= r):
            mid = (l + r) // 2
            if(arr[mid] >= arr[l]):
                idx = max(idx, arr[mid])
                l += 1
            else:
                idx = max(idx, arr[mid]) 
                r -= 1     
        return arr.index(idx)
        