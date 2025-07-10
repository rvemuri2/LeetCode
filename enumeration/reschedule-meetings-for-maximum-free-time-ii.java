import java.util.*;

class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] duration = new int[n];
        for (int i = 0; i < n; i++) {
            duration[i] = endTime[i] - startTime[i];
        }

        // Calculate current free time gaps
        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0] - 0; // before first meeting
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1]; // after last meeting

        // Calculate current maximum free time
        int maxFree = 0;
        for (int gap : gaps) {
            maxFree = Math.max(maxFree, gap);
        }

        // Try moving each meeting to maximize free time
        for (int i = 0; i < n; i++) {
            // Remove meeting i, recompute gaps
            int[] tempGaps = new int[n];
            tempGaps[0] = (i == 0 ? startTime[1] : startTime[0]) - 0;
            int idx = 1;
            for (int j = 1; j < n; j++) {
                if (j == i) continue;
                int prevEnd = (j - 1 == i) ? (j - 2 >= 0 ? endTime[j - 2] : 0) : endTime[j - 1];
                tempGaps[idx++] = startTime[j] - prevEnd;
            }
            tempGaps[idx - 1] = eventTime - (i == n - 1 ? endTime[n - 2] : endTime[n - 1]);

            // Calculate max gap without meeting i
            int curMax = 0;
            for (int gap : tempGaps) {
                curMax = Math.max(curMax, gap);
            }

            // Try placing meeting i into each gap
            for (int gap : tempGaps) {
                if (gap >= duration[i]) {
                    // Remaining gap after placing meeting i here
                    curMax = Math.max(curMax, gap - duration[i]);
                }
            }

            maxFree = Math.max(maxFree, curMax);
        }

        return maxFree;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxFreeTime(5, new int[]{1,3}, new int[]{2,5})); // 2
        System.out.println(sol.maxFreeTime(10, new int[]{0,7,9}, new int[]{1,8,10})); // 7
        System.out.println(sol.maxFreeTime(10, new int[]{0,3,7,9}, new int[]{1,4,8,10})); // 6
        System.out.println(sol.maxFreeTime(5, new int[]{0,1,2,3,4}, new int[]{1,2,3,4,5})); // 0
    }
}