class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        left = 0
        right = 0
        length = 0
        char = set()

        while(left < len(s) and right < len(s)):

            if(s[right] not in char):
                char.add(s[right])
                right += 1
                length = max(length, len(char))
            
            while(s[right] in char):
                char.remove(s[left])
                left += 1
                char.add(s[left])
        
        return length
            
        