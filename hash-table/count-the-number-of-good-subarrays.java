import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countGood(new int[]{1, 1, 1, 1, 1}, 10));       // Output: 1
        System.out.println(sol.countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2)); 
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
            pairs += f;
            freq.put(val, f + 1);

            while (pairs >= k) {
                count += (n - right);
                int leftVal = nums[left];
                int fLeft = freq.get(leftVal);
                pairs -= fLeft - 1;
                freq.put(leftVal, fLeft - 1);
                left++;
            }
        }

        return count;
    }
}
