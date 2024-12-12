class Solution:
    def kthLargestNumber(self, nums: List[str], k: int) -> str:

        nums_2 = []

        heap = []

        for i in nums:
            nums_2.append(int(i))
        
        for num in nums_2:
            heapq.heappush(heap, -num)
        
        while(k > 0):
            val = heapq.heappop(heap)
            k -= 1
        
        return str(abs(val))


        