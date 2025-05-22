public class Solution {
    public int minimumEqualSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int z1 = 0, z2 = 0;

        // Compute sums and zero counts
        for (int num : nums1) {
            if (num == 0) z1++;
            else sum1 += num;
        }
        for (int num : nums2) {
            if (num == 0) z2++;
            else sum2 += num;
        }

        // Helper: check if a given target sum is feasible
        long low = Math.max(sum1 + z1, sum2 + z2); // minimum feasible sum
        long high = (long) 1e12; // arbitrarily large upper bound
        long answer = -1;

        while (low <= high) {
            long mid = (low + high) / 2;

            long fill1 = mid - sum1;
            long fill2 = mid - sum2;

            if (fill1 >= z1 && fill2 >= z2) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minimumEqualSum(new int[]{3, 2, 0, 1, 0}, new int[]{6, 5, 0})); // 12
        System.out.println(sol.minimumEqualSum(new int[]{2, 0, 2, 0}, new int[]{1, 4}));      // -1
    }
}