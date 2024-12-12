class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:


        heap = []
        
        for num in nums:
            heapq.heappush(heap, -int(num))
        
        while(k > 0):
            val = heapq.heappop(heap)
            k -= 1
        
        return str(abs(val))


        