import java.util.*;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Base case: equal strings
        if (s1.equals(s2)) return true;

        // Base case: mismatched characters
        if (s1.length() != s2.length()) return false;

        // Memoization key
        String key = s1 + "," + s2;
        if (memo.containsKey(key)) return memo.get(key);

        // Quick check: must contain same chars
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();
        // Try all possible splits
        for (int i = 1; i < n; i++) {
            // Without swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // With swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}