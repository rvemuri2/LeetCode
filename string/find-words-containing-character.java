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
            // Check if the current word contains the character x
            if (words[i].indexOf(x) != -1) {
                // If it does, add the index to the result list
                result.add(i);
            }
        }

        // Return the list of matching indices
        return result;
    }

    // Main method to test the functionality with example inputs
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: both words contain 'e'
        System.out.println(sol.findWordsContaining(new String[]{"leet", "code"}, 'e')); // Output: [0, 1]

        // Test case 2: 'a' is in "abc" and "aaaa"
        System.out.println(sol.findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a')); // Output: [0, 2]

        System.out.println(sol.findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'z'));
    }
}