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

        int maxVal = Integer.parseInt(maxStr);
        int minVal = Integer.parseInt(minStr);
        return maxVal - minVal;
    }
}