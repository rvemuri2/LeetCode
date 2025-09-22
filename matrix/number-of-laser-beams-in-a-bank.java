public class Solution {
    /**
     * Count the number of laser beams between security devices in the bank.
     * 
     * @param bank binary string array representing the floor plan
     * @return total number of beams
     */
    public int numberOfBeams(String[] bank) {
        int prev = 0;   // number of devices in the last non-empty row
        int beams = 0;

        for (String row : bank) {
            int cnt = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') {
                    cnt++;
                }
            }

            if (cnt > 0) {
                beams += prev * cnt;
                prev = cnt;
            }
        }

        return beams;
    }
}