public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            totalGas += gain;
            currentGas += gain;

            // If currentGas drops below 0, we cannot start from current segment
            if (currentGas < 0) {
                startIndex = i + 1;
                currentGas = 0;
            }
        }
        return totalGas >= 0 ? startIndex : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

    }
}
