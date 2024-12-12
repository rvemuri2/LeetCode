class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:

        graph = defaultdict(float)

        heap = []

        res = []

        for i in points:

            calc = math.pow(i[0], 2) + math.pow(i[1], 2)

            val = math.sqrt(calc)

            graph[tuple(i)] = graph.get(tuple(i), 0) + val
        
        for key, val in graph.items():
            if(len(heap) < k):
                heapq.heappush(heap, (-val, key))
            else:
                heapq.heappushpop(heap, (-val, key))
        
        print(heap)
        while(heap):
            freq, element = heapq.heappop(heap)
            res.append(element)

        

        print(graph)
        return res
        
        
        