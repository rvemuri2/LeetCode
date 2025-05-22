public class Solution {
    static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        long[] count = new long[26];

        // Initialize counts from initial string
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Perform t transformations
        for (int i = 0; i < t; i++) {
            long[] next = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25) { // 'z' → "ab"
                    next[0] = (next[0] + count[25]) % MOD; // 'a'
                    next[1] = (next[1] + count[25]) % MOD; // 'b'
                } else { // 'c' → 'c'+1
                    next[j + 1] = (next[j + 1] + count[j]) % MOD;
                }
            }
            count = next;
        }

        // Sum up total characters after t transformations
        long result = 0;
        for (long c : count) {
            result = (result + c) % MOD;
        }

        return (int) result;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.transformedLength("abcyy", 2)); // Output: 7
        System.out.println(sol.transformedLength("azbk", 1));   // Output: 5
    }
}
