class Solution(object):
    def nextGreatestLetter(self, letters, target):
        """
        :type letters: List[str]
        :type target: str
        :rtype: str
        """

        l = 0
        r = len(letters) - 1
        val = float('infinity')

        while(l <= r):

            mid = (l + r) // 2

            if(ord(letters[mid]) > ord(target)):
                val = min(val, mid)
                r = mid - 1

            elif(ord(letters[mid]) <= ord(target)):

                l = mid + 1
        
        return letters[0] if val == float('infinity') else letters[val] 
        