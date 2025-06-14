class Solution {
    /**
     * Returns the difference between the maximum and minimum values Bob can make
     * by remapping exactly one digit in the number.
     */
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);

        // Get maximum by changing the first non-9 digit to 9
        char toReplaceMax = ' ';
        for (char c : s.toCharArray()) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        String maxStr = s;
        if (toReplaceMax != ' ') {
            maxStr = s.replace(toReplaceMax, '9');
        }

        // Get minimum by changing the first digit that is not 0 to 0
        char toReplaceMin = s.charAt(0); // Always can replace the first digit
        String minStr = s.replace(toReplaceMin, '0');

        // Convert back to int and compute difference
        int maxVal = Integer.parseInt(maxStr);
        int minVal = Integer.parseInt(minStr);

        return maxVal - minVal;
    }

    // Example usage with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Test 1: " + sol.minMaxDifference(11891)); // Expected: 99009
        System.out.println("Test 2: " + sol.minMaxDifference(90));    // Expected: 99
        System.out.println("Test 3: " + sol.minMaxDifference(99999)); // Expected: 0
    }
}