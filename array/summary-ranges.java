import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return result;

        int start = nums[0];

        for (int i = 1; i <= n; i++) {
            // Either end of array or non-consecutive number
            if (i == n || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }

                if (i < n) {
                    start = nums[i]; // start next range
                }
            }
        }

        return result;
    }

    // Optional main method for quick testing
    public static void main(String[] args) {}
}
