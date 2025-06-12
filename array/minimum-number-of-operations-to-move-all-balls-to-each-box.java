class Solution {
    /**
     * Calculates the minimum number of operations to move all balls to each box.
     *
     * @param boxes A binary string where '1' means the box contains a ball and '0' means it's empty.
     * @return An array where each element is the minimum operations to gather all balls to that box.
     */
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        // Left pass: count operations and balls from the left
        int balls = 0;     // Number of balls to the left (including current)
        int ops = 0;       // Accumulated operations from the left

        for (int i = 0; i < n; i++) {
            answer[i] += ops;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            ops += balls; // Next position will need one more move for each ball
        }

        // Right pass: count operations and balls from the right
        balls = 0;
        ops = 0;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] += ops;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            ops += balls;
        }

        return answer;
    }

    // Example usage and test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        String test1 = "110";
        System.out.println("Expected: [1,1,3], Got: " + java.util.Arrays.toString(sol.minOperations(test1)));

        String test2 = "001011";
        System.out.println("Expected: [11,8,5,4,3,4], Got: " + java.util.Arrays.toString(sol.minOperations(test2)));

        String test3 = "1";
    }
}