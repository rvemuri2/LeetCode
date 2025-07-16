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
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        
        return count;
    }
}