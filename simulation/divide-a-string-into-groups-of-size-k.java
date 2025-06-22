import java.util.*;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        // Calculate number of groups needed
        int n = s.length();
        int groups = (n + k - 1) / k; // Ceiling of n / k

        String[] result = new String[groups];
        int index = 0;

        for (int i = 0; i < n; i += k) {
            StringBuilder group = new StringBuilder();

            // Collect up to k characters starting at i
            for (int j = i; j < i + k; j++) {
                if (j < n) {
                    group.append(s.charAt(j));
                } else {
                    group.append(fill); // Add fill character if string ends
                }
            }

            result[index++] = group.toString();
        }

        return result;
    }

    // Example test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}