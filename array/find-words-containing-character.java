import java.util.*;
class Solution {
    /**
     * This method returns a list of indices of words that contain the given character x.
     * 
     * @param words An array of lowercase strings
     * @param x A lowercase character to search for in the words
     * @return A list of indices where the word contains the character x
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }
}