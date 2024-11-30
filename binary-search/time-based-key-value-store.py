class TimeMap:

    def __init__(self):
        self.hash = {}
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.hash[key] = self.hash.get(key, [])
        self.hash[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        res = ""
        values = self.hash.get(key, [])

        l = 0
        r = len(values) - 1

        while(l <= r):
            mid = (l + r) // 2
            if(timestamp >= values[mid][1]):
                res = values[mid][0]
                l = mid + 1
            else:
                r = mid - 1
        return res



# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)