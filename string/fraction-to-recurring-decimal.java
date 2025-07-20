import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        // Convert to long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append integer part
        sb.append(num / den);
        long remainder = num % den;

        if (remainder == 0) return sb.toString();

        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();  // Remainder -> Position

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }

            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // ✅ Test cases
        System.out.println(sol.fractionToDecimal(1, 2));      // 0.5
        System.out.println(sol.fractionToDecimal(2, 1));      // 2
        System.out.println(sol.fractionToDecimal(4, 333));    // 0.(012)
        System.out.println(sol.fractionToDecimal(1, 6));      // 0.1(6)
        System.out.println(sol.fractionToDecimal(1, 3));      // 0.(3)
        System.out.println(sol.fractionToDecimal(-1, 2));     // -0.5
        System.out.println(sol.fractionToDecimal(-50, 8));    // -6.25
        System.out.println(sol.fractionToDecimal(-1, -2147483648));
    }
}
