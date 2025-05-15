import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substr = s.substring(start, end);
            if (isPalindrome(substr)) {
                path.add(substr);                     // Choose
                backtrack(s, end, path, result);      // Explore
                path.remove(path.size() - 1);         // Un-choose
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.partition("aab")); // Output: [["a","a","b"],["aa","b"]]
        System.out.println(sol.partition("a"));   // Output: [["a"]]
    }
}
