

class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> perm = new ArrayList<>(m);
        for (int x = 1; x <= m; x++) {
            perm.add(x);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int idx = perm.indexOf(q);
            res[i] = idx;

            perm.remove(idx);
            perm.add(0, q);
        }
        return res;
    }
}