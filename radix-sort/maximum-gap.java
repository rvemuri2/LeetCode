class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find min and max of the array
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Edge case: all elements are the same
        if (min == max) return 0;

        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1)); // Size of each bucket
        int bucketCount = (max - min) / bucketSize + 1;

        // Initialize buckets
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] bucketUsed = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Place each number in a bucket
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            bucketUsed[idx] = true;
        }

        // Calculate max gap between buckets
        int maxGap = 0;
        int prevBucketMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!bucketUsed[i]) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prevBucketMax);
            prevBucketMax = bucketMax[i];
        }

        return maxGap;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumGap(new int[]{3, 6, 9, 1}));
    }
}