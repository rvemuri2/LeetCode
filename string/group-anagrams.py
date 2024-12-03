import collections from defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(list)

        for i in strs:
            arr = [0] * 26
        
            for j in i:
                arr[ord(j) - ord("a")] += 1

            map[tuple(arr)].append(i)

        return map.values()
            
            

        