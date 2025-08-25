import java.util.*;

/**
 * Find all 10-letter-long DNA sequences that occur more than once.
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final int L = 10;
        int n = s.length();
        if (n < L) {
            return Collections.emptyList();
        }

        int[] enc = new int[26];
        enc['A' - 'A'] = 0;
        enc['C' - 'A'] = 1;
        enc['G' - 'A'] = 2;
        enc['T' - 'A'] = 3;

        int mask = (1 << (2 * L)) - 1;
        int code = 0;

        for (int i = 0; i < L; i++) {
            code = (code << 2) | enc[s.charAt(i) - 'A'];
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        seen.add(code);

        for (int i = L; i < n; i++) {
            code = ((code << 2) & mask) | enc[s.charAt(i) - 'A'];
            if (!seen.add(code)) {
                repeated.add(s.substring(i - L + 1, i + 1));
            }
        }

        return new ArrayList<>(repeated);
    }
}
