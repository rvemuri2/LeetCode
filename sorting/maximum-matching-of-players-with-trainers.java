import java.util.Arrays;

public class Solution {
    // Main matching logic using greedy two-pointer approach
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Sort both arrays so we can match players in increasing ability
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int i = 0; // Pointer for players
        int j = 0; // Pointer for trainers
        int count = 0; // Count of successful matchings
        
        // Try to match each player with the least capable valid trainer
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                // Match found: player[i] can be trained by trainer[j]
                count++;
                i++;
                j++;
            } else {
                // Trainer[j] is too weak, try next stronger trainer
                j++;
            }
        }
        
        return count;
    }

    // Test cases to verify the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] players1 = {4, 7, 9};
    }
}