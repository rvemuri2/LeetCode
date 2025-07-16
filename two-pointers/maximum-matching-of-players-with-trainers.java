class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int count = 0;
        int i = 0; // pointer for players
        int j = 0; // pointer for trainers
        
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