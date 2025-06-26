import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map of characters in t
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        int left = 0, right = 0;
        int required = tFreq.size();
        int formed = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();

        // Result: [window length, left, right]
        int[] res = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window
            while (left <= right && formed == required) {
                if (res[0] == -1 || right - left + 1 < res[0]) {
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }

                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar) < tFreq.get(leftChar)) {
                    formed--;
                }

                left++; // Shrink the window
            }

            right++; // Expand the window
        }

        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println(sol.minWindow("a", "a"));               // "a"
    }
}
