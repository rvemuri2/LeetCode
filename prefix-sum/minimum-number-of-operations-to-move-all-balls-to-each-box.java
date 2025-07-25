class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

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