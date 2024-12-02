class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        
        length = len(searchWord)

        sentence = sentence.split(" ")

        for i in range(len(sentence)):

            if(sentence[i][:length] == searchWord):
                return i+1
        
        return -1

        
