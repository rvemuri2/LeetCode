class Solution:
    def removeDuplicates(self, s: str) -> str:

        str1 = ""
        arr = []

        for i in s:

            if i in arr:

                arr.remove(i)
            
            else:
                arr.append(i)

            
        
        return "".join(arr)
        