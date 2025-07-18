import java.util.*;

class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;

        long[] leftSums = new long[len];
        long[] rightSums = new long[len];

        // Max heap for left n smallest sum
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftSum = 0;
        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            if (maxHeap.size() == n) {
                leftSums[i] = leftSum;
            } else {
                leftSums[i] = Long.MAX_VALUE;
            }
        }

        // Min heap for right n largest sum
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        for (int i = len - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            if (minHeap.size() == n) {
                rightSums[i] = rightSum;
            } else {
                rightSums[i] = Long.MIN_VALUE;
            }
        }

        // Calculate the minimum difference
        long minDiff = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            if (leftSums[i] != Long.MAX_VALUE && rightSums[i + 1] != Long.MIN_VALUE) {
                minDiff = Math.min(minDiff, leftSums[i] - rightSums[i + 1]);
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
    }
}
