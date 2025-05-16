import java.util.*;

public class Solution {

    // Method to find the length of the longest consecutive sequence
    public int longestConsecutive(int[] nums) {
        // Use a HashSet for O(1) lookup time
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num); // Duplicates are automatically handled
        }

        int longestStreak = 0;

        // Iterate through the set
        for (int num : numSet) {
            // Only start a new sequence if num - 1 is not in the set
            // This ensures we only start from the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count upwards while consecutive numbers exist
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // Main method for testing the function
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest sequence length: " + sol.longestConsecutive(nums1)); // Output: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest sequence length: " + sol.longestConsecutive(nums2)); // Output: 9

        int[] nums3 = {1, 0, 1, 2};
        System.out.println("Longest sequence length: " + sol.longestConsecutive(nums3)); // Output: 3

        int[] nums4 = {};
        System.out.println("Longest sequence length: " + sol.longestConsecutive(nums4)); // Output: 0
    }
}
