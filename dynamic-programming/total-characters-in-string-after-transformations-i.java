public class Solution {
    static final int MOD = 1_000_000_007;

    // Method to compute the length of the string after t transformations
    public int lengthAfterTransformations(String s, int t) {
        long[] count = new long[26]; // Frequency count for characters 'a' to 'z'

        // Initialize frequency counts from the original string
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Perform t transformations
        for (int step = 0; step < t; step++) {
            long[] next = new long[26]; // New frequency count for this transformation

            for (int i = 0; i < 26; i++) {
                if (i == 25) {
                    // 'z' becomes "ab" → increases length by 1
                    next[0] = (next[0] + count[25]) % MOD; // 'a'
                    next[1] = (next[1] + count[25]) % MOD;
                } else {
                    next[i + 1] = (next[i + 1] + count[i]) % MOD;
                }
            }
            count = next;
        }
        long result = 0;
        for (long c : count) {
            result = (result + c) % MOD;
        }
        return (int) result;
    }
}
