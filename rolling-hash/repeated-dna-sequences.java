import java.util.*;

/**
 * Find all 10-letter-long DNA sequences that occur more than once.
 * Time: O(n), Space: O(n)
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final int L = 10;
        int n = s.length();
        if (n < L) return Collections.emptyList();

        // Encode A,C,G,T into 2 bits: A->00, C->01, G->10, T->11
        int[] enc = new int[26];
        enc['A' - 'A'] = 0;  // 00
        enc['C' - 'A'] = 1;  // 01
        enc['G' - 'A'] = 2;  // 10
        enc['T' - 'A'] = 3;  // 11

        int mask = (1 << (2 * L)) - 1; // keep only the lowest 20 bits
        int code = 0;

        // Build initial window
        for (int i = 0; i < L; i++) {
            code = (code << 2) | enc[s.charAt(i) - 'A'];
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        seen.add(code);

        // Slide window over the string
        for (int i = L; i < n; i++) {
            code = ((code << 2) & mask) | enc[s.charAt(i) - 'A'];
            if (!seen.add(code)) {
                // Already seen this 10-letter encoding -> repeated
                repeated.add(s.substring(i - L + 1, i + 1));
            }
        }

        return new ArrayList<>(repeated);
    }

    // Quick tests
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        // Expected: ["AAAAACCCCC","CCCCCAAAAA"] (order may vary)

        System.out.println(sol.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        // Expected: ["AAAAAAAAAA"]

        System.out.println(sol.findRepeatedDnaSequences("ACGTACGTAC"));
        // Expected: [] (length = 10, occurs once)

        System.out.println(sol.findRepeatedDnaSequences("ACGTACGTACGT"));
        // "ACGTACGTAC" and "CGTACGTACG" and "GTACGTACGT" repeat? Only "ACGTACGTAC" appears twice (positions 0..9 and 2..11 doesn't match; actual repeats depend on string)
        // For this input, result: ["ACGTACGTAC"] if repeating exists

        System.out.println(sol.findRepeatedDnaSequences("A"));
        // Expected: []
    }
}
