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
        int balls = 0;
        int ops = 0; 

        for (int i = 0; i < n; i++) {
            answer[i] += ops;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            ops += balls;
        }

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
}