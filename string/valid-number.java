class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        if (n == 0) return false;

        int i = 0;

        // 1) Optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        boolean isNumeric = false;

        // 2) Integer part (digits before decimal)
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }

        // 3) Decimal part
        if (i < n && s.charAt(i) == '.') {
            i++;
            // digits after decimal
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }

        // If we have no digits at all in integer or fraction, it's invalid
        if (!isNumeric) return false;

        // 4) Exponent part
        if (i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            // After 'e' or 'E', there may be an optional sign
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            // Must have at least one digit in exponent
            boolean hasExpDigits = false;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                hasExpDigits = true;
            }
            if (!hasExpDigits) return false;
        }

        // 5) We must have consumed the entire string
        return i == n;
    }

    // Optional main for quick tests
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Valid numbers
        System.out.println(sol.isNumber("2"));         // true
        System.out.println(sol.isNumber("0089"));      // true
        System.out.println(sol.isNumber("-0.1"));      // true
        System.out.println(sol.isNumber("+3.14"));     // true
        System.out.println(sol.isNumber("4."));        // true
        System.out.println(sol.isNumber("-.9"));       // true
        System.out.println(sol.isNumber("2e10"));      // true
        System.out.println(sol.isNumber("-90E3"));     // true
        System.out.println(sol.isNumber("3e+7"));      // true
        System.out.println(sol.isNumber("+6e-1"));     // true
        System.out.println(sol.isNumber("53.5e93"));   // true
        System.out.println(sol.isNumber("-123.456e789")); // true

        // Invalid numbers
        System.out.println(sol.isNumber("abc"));       // false
        System.out.println(sol.isNumber("1a"));        // false
        System.out.println(sol.isNumber("1e"));
    }
}