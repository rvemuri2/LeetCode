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
        Solution sol = new Solution();

        // Example 1
        int[] queries1 = {3, 1, 2, 1};
        int m1 = 5;
        int[] result1 = sol.processQueries(queries1, m1);
        System.out.print("Output 1: ");
        printArray(result1); // Expected [2, 1, 2, 1]

        // Example 2
        int[] queries2 = {4, 1, 2, 2};
        int m2 = 4;
        int[] result2 = sol.processQueries(queries2, m2);
        System.out.print("Output 2: ");
        printArray(result2); // Expected [3, 1, 2, 0]
    }
}