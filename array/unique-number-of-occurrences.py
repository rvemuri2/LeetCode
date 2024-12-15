class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:

        count = Counter(arr)

        arr2 = []

        for key, value in count.items():

            if(value in arr2):
                return False
            
            arr2.append(value)
        
        return True

        