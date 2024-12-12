class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:

        max_heap = []
        for num in stones:
            heapq.heappush(max_heap, -num)
        
        while(len(max_heap) > 1):
            stone1 = -heapq.heappop(max_heap)
            stone2 = -heapq.heappop(max_heap)

            if(stone1 > stone2):
                heapq.heappush(max_heap, -(stone1 - stone2))
            elif(stone2 > stone1):
                heapq.heappush(max_heap, -(stone2 - stone1))

        if(max_heap):
            return abs(max_heap[0])
        else:
            return 0
        