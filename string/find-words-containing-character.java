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
        // Create a list to store the indices of words that contain the character x
        List<Integer> result = new ArrayList<>();
        // Loop through each word in the array
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }
}