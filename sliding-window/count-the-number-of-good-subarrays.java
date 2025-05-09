import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countGood(new int[]{1, 1, 1, 1, 1}, 10));       // Output: 1
        System.out.println(sol.countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));  // Output: 4
    }

    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0;
        int n = nums.length;
        int left = 0;
        long pairs = 0;

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            int f = freq.getOrDefault(val, 0);
            pairs += f; // Add f new pairs (val, val) with current count
            freq.put(val, f + 1);

            // Shrink window until we drop below k pairs
            while (pairs >= k) {
                count += (n - right); // All subarrays starting at left and ending >= right are good
                int leftVal = nums[left];
                int fLeft = freq.get(leftVal);
                pairs -= fLeft - 1; // Remove (fLeft - 1) pairs involving nums[left]
                freq.put(leftVal, fLeft - 1);
                left++;
            }
        }

        return count;
    }
}
