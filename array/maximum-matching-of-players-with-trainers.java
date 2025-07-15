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
        int[] trainers1 = {8, 2, 5, 8};
        System.out.println("Test 1 Output: " + sol.matchPlayersAndTrainers(players1, trainers1)); // Expected: 2

        int[] players2 = {1, 1, 1};
        int[] trainers2 = {10};
        System.out.println("Test 2 Output: " + sol.matchPlayersAndTrainers(players2, trainers2)); // Expected: 1

        int[] players3 = {5, 6, 7};
        int[] trainers3 = {1, 2, 3};
        System.out.println("Test 3 Output: " + sol.matchPlayersAndTrainers(players3, trainers3)); // Expected: 0

        int[] players4 = {2, 4, 6};
        int[] trainers4 = {1, 3, 5, 7};
        System.out.println("Test 4 Output: " + sol.matchPlayersAndTrainers(players4, trainers4)); // Expected: 3

        int[] players5 = {1, 2, 3, 4, 5};
        int[] trainers5 = {2, 2, 2, 2, 2};
        System.out.println("Test 5 Output: " + sol.matchPlayersAndTrainers(players5, trainers5)); // Expected: 2

        int[] players6 = {1_000_000_000};
    }
}