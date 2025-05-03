import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.letterCombinations("23"));   // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        System.out.println(sol.letterCombinations(""));     // []
        System.out.println(sol.letterCombinations("2"));    // ["a", "b", "c"]
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Digit-to-letter mapping based on a phone keypad
        String[] phoneMap = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), result, phoneMap);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current,
                           List<String> result, String[] phoneMap) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phoneMap[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            current.append(c); // Choose
            backtrack(digits, index + 1, current, result, phoneMap); // Explore
            current.deleteCharAt(current.length() - 1); // Un-choose
        }
    }
}
