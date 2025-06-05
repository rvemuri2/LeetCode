class Solution {
    private int[] parent = new int[26];

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union two sets by making the lexicographically smaller root the parent
    private void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return;
        if (rx < ry) {
            parent[ry] = rx;
        } else {
            parent[rx] = ry;
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize DSU parent pointers
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        int len = s1.length();
        // Union each pair of equivalent characters
        for (int i = 0; i < len; i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build the result by mapping each char in baseStr to its smallest equivalent
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int root = find(c - 'a');
            sb.append((char) (root + 'a'));
        }

        return sb.toString();
    }

    // Optional main for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.smallestEquivalentString(
            "parker", "morris", "parser"
        )); // Expected "makkek"

        System.out.println(sol.smallestEquivalentString(
            "", "", ""
        ));
    }
}