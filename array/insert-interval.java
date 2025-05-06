import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println(Arrays.deepToString(sol.insert(intervals1, newInterval1)));
        // Output: [[1,5],[6,9]]

        // Test case 2
        int[][] intervals2 = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval2 = {4,8};
        System.out.println(Arrays.deepToString(sol.insert(intervals2, newInterval2)));
        // Output: [[1,2], [3,10], [12,16]]
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // Update newInterval to be the merged interval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged newInterval
        result.add(newInterval);

        // Step 3: Add all remaining intervals that come after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert list to array and return
        return result.toArray(new int[result.size()][]);
    }
}
