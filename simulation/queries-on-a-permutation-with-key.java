import java.util.*;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        // Initialize permutation P = [1, 2, ..., m]
        List<Integer> perm = new ArrayList<>(m);
        for (int x = 1; x <= m; x++) {
            perm.add(x);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            // Find index of the query in the permutation
            int idx = perm.indexOf(q);
            res[i] = idx;

            // Move this number to the front of the permutation
            perm.remove(idx);
            perm.add(0, q);
        }
        return res;
    }

    // Simple method to print arrays
    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
    }
}