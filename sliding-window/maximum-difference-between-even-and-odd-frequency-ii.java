class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int maxDiff = Integer.MIN_VALUE;

        // Try all substrings of length >= k
        for (int i = 0; i < n; i++) {
            int[] freq = new int[5];  // digits '0' to '4'

            for (int j = i; j < n; j++) {
                int digit = s.charAt(j) - '0';
                freq[digit]++;

                int len = j - i + 1;
                if (len >= k) {
                    // Now check all pairs (a, b)
                    for (int a = 0; a < 5; a++) {
                        if (freq[a] % 2 == 1) { // a must be odd
                            for (int b = 0; b < 5; b++) {
                                if (freq[b] % 2 == 0 && freq[b] > 0) { // b must be even and appear
                                    maxDiff = Math.max(maxDiff, freq[a] - freq[b]);
                                }
                            }
                        }
                    }
                }
            }
        }

        return maxDiff == Integer.MIN_VALUE ? -1 : maxDiff;
    }
}
