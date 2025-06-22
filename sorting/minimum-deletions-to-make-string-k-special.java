import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Integer> freqs = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) {
                freqs.add(f);
            }
        }

        Collections.sort(freqs);

        int n = freqs.size();
        int minDeletions = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int targetFreq = freqs.get(i);
            int maxAllowed = targetFreq + k;
            int deletions = 0;

            for (int j = 0; j < n; j++) {
                int f = freqs.get(j);
                if (f < targetFreq) {
                    deletions += f;
                } else if (f > maxAllowed) {
                    deletions += f - maxAllowed;
                }
            }

            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}
