class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        freq = Counter(nums)

        heap = []

        for key, val in freq.items():
            if(len(heap) < k):
                heapq.heappush(heap, (key))
        
        return heap[:k+1]

                


        