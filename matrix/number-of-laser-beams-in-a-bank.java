public class Solution {
    /**
     * Count the number of laser beams between security devices in the bank.
     * 
     * @param bank binary string array representing the floor plan
     * @return total number of beams
     */
    public int numberOfBeams(String[] bank) {
        int prev = 0;   // number of devices in the last non-empty row
        int beams = 0;  // running total of beams

        for (String row : bank) {
            // Count devices ('1') in this row
            int cnt = 0;
            for (int i = 0; i < row.length(); i++) {
                if (row.charAt(i) == '1') cnt++;
            }

            // Only process if this row has at least one device
            if (cnt > 0) {
                // Each device in this row connects with every device in the previous non-empty row
                beams += prev * cnt;
                // Update prev to current row count
                prev = cnt;
            }
            // If cnt == 0, skip; beams cannot "jump over" empty rows
        }

        return beams;
    }

    // ----------------- TESTS -----------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String[] bank1 = {"011001","000000","010100","001000"};
        System.out.println("Test 1: " + sol.numberOfBeams(bank1)); 
        // Expected: 8

        // Example 2
        String[] bank2 = {"000","111","000"};
        System.out.println("Test 2: " + sol.numberOfBeams(bank2)); 
        // Expected: 0

        // Case 3: only one row with devices → no beams
        String[] bank3 = {"10101"};
        System.out.println("Test 3: " + sol.numberOfBeams(bank3)); 
    }
}