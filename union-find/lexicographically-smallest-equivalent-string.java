class Solution {
    private int[] parent = new int[26];

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

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
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int root = find(c - 'a');
            sb.append((char) (root + 'a'));
        }

        return sb.toString();
    }
}