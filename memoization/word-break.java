import java.util.*;

class Solution {
    /**
     * Determines if the input string `s` can be segmented into a sequence
     * of one or more words from the dictionary `wordDict`.
     *
     * @param s         The input string to segment.
     * @param wordDict  The list of valid words that can be used for segmentation.
     * @return          True if `s` can be segmented, otherwise false.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // for fast lookup
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string can always be segmented

        // dp[i] = true if s[0...i-1] can be segmented using wordDict
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if s[j...i-1] is a word and s[0...j-1] is segmentable
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further j's
                }
            }
        }

        return dp[n];
    }

    // Example test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
        System.out.println(sol.wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // true
        System.out.println(sol.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
    }
}