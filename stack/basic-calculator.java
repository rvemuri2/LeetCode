import java.util.*;

class Solution {
    public int calculate(String s) {
        int n = s.length();
        int res = 0;       // current accumulated result
        int num = 0;       // current number being built
        int sign = 1;      // current sign (+1 or -1)
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= st.pop();
                res += st.pop();
            } else if (c == ' ') {
                continue;
            }
        }

        res += sign * num;
        return res;
    }
}