import java.util.*;

/**
 * Different Ways to Add Parentheses
 * ---------------------------------
 * Divide & conquer + memoization:
 * - For each operator in the expression, split into left/right substrings.
 * - Recursively compute all results for left and right.
 * - Combine each pair using the operator.
 * - If the substring has no operator, it's a plain number -> single result.
 *
 * Time:
 *   Catalan-like number of splits; memoization prevents recomputing substrings.
 *   expression length <= 20, so this is easily fast enough.
 */
class Solution {
    private final Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        return compute(expression);
    }

    private List<Integer> compute(String expr) {
        if (memo.containsKey(expr)) return memo.get(expr);

        List<Integer> res = new ArrayList<>();
        int n = expr.length();

        for (int i = 0; i < n; i++) {
            char ch = expr.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String leftStr = expr.substring(0, i);
                String rightStr = expr.substring(i + 1);

                List<Integer> leftVals = compute(leftStr);
                List<Integer> rightVals = compute(rightStr);

                for (int a : leftVals) {
                    for (int b : rightVals) {
                        res.add(apply(a, b, ch));
                    }
                }
            }
        }

        // If no operator found, it's a number literal
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expr));
        }

        memo.put(expr, res);
        return res;
    }

    private int apply(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            default:  return a * b; // '*'
        }
    }

    // --- Simple test harness ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Example 1:");
        System.out.println(sol.diffWaysToCompute("2-1-1")); // [0, 2]

        System.out.println("Example 2:");
        System.out.println(sol.diffWaysToCompute("2*3-4*5")); // [-34,-14,-10,-10,10]

        System.out.println("Single number:");
        System.out.println(sol.diffWaysToCompute("42")); // [42]

        System.out.println("Mixed multi-digit:");
        System.out.println(sol.diffWaysToCompute("12+3*4-5")); // results may vary in order

        System.out.println("Another check:");
        System.out.println(sol.diffWaysToCompute("10*5-3*2")); // results may vary in order
    }
}