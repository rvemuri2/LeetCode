import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Store only non-zero frequencies
        List<Integer> freqs = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) freqs.add(f);
        }

        // Sort frequencies
        Collections.sort(freqs);

        int n = freqs.size();
        int minDeletions = Integer.MAX_VALUE;

        // Try keeping each frequency as upper bound and delete others to make all freqs <= f and >= f - k
        for (int i = 0; i < n; i++) {
            int targetFreq = freqs.get(i);
            int maxAllowed = targetFreq + k;
            int deletions = 0;

            for (int j = 0; j < n; j++) {
                int f = freqs.get(j);
                if (f < targetFreq) {
                    deletions += f; // Remove all
                } else if (f > maxAllowed) {
                    deletions += f - maxAllowed; // Reduce to maxAllowed
                }
            }

            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }

    // Sample test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.minimumDeletions("aabcaba", 0));     // Output: 3
        System.out.println(sol.minimumDeletions("dabdcbdcdcd", 2)); // Output: 2
        System.out.println(sol.minimumDeletions("aaabaaa", 2));     // Output: 1
        System.out.println(sol.minimumDeletions("abcde", 0));
    }
}
