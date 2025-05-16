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
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
