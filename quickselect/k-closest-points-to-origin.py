class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:

        minHeap = []

        for x, y in points:
            calc = (x ** 2) + (y ** 2)
            minHeap.append([calc, x, y])

        heapq.heapify(minHeap)
        res = []

        while(k > 0):
            val = heapq.heappop(minHeap)
            res.append([val[1], val[2]])
            k -= 1
        
        return res
        
        
        