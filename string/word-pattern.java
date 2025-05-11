import java.util.*;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Forward mapping: pattern -> word
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) return false;
            } else {
                charToWord.put(c, word);
            }

            // Reverse mapping: word -> pattern
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) return false;
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

    // Test driver
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.wordPattern("abba", "dog cat cat dog"));  // true
        System.out.println(sol.wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(sol.wordPattern("aaaa", "dog cat cat dog"));  // false
        System.out.println(sol.wordPattern("abc", "dog cat fish"));      // true
    }
}
