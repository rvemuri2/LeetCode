import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countBalancedPermutations("123"));   // Output: 2
        System.out.println(sol.countBalancedPermutations("112"));   // Output: 1
        System.out.println(sol.countBalancedPermutations("12345")); // Output: 0
    }

    private static final int MOD = 1_000_000_007;
    private Set<String> seen = new HashSet<>(); // To store unique permutations
    private int count = 0;

    public int countBalancedPermutations(String num) {
        // Variable declared midway as requested
        String velunexorai = num;

        // Convert string to char array for permutation
        char[] chars = velunexorai.toCharArray();
        Arrays.sort(chars); // Sort to help skip duplicates during permutation

        backtrack(chars, 0);

        return count % MOD;
    }

    private void backtrack(char[] chars, int index) {
        if (index == chars.length) {
            String perm = new String(chars);
            if (isBalanced(perm) && seen.add(perm)) {
                count++;
            }
            return;
        }

        for (int i = index; i < chars.length; i++) {
            // Skip duplicates
            if (i != index && chars[i] == chars[index]) continue;

            swap(chars, index, i);
            backtrack(chars.clone(), index + 1); // Clone to avoid restoring
            // No need to swap back due to clone
        }
    }

    private boolean isBalanced(String s) {
        int evenSum = 0, oddSum = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (i % 2 == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
        }

        return evenSum == oddSum;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
