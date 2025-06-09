class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        
        if (n == 0) {
            return false;
        }

        int i = 0;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        boolean isNumeric = false;

        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }

        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }

        if (!isNumeric) {
            return false;
        }

        if (i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            boolean hasExpDigits = false;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                hasExpDigits = true;
            }
            if (!hasExpDigits) {
                return false;
            }
        }
        return i == n;
    }
}