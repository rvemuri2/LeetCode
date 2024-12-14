class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:

        count_words = Counter(words)

        heap = []

        for key, val in count_words.items():

            heapq.heappush(heap, (-val, key))
    
        res = []
        while(k > 0):
            frequency, element = heapq.heappop(heap)
            res.append(element) 
            k -= 1
    
        return res
        