import java.util.*;

class Solution {
    public int calculate(String s) {
        int n = s.length();
        int res = 0;       // current accumulated result
        int num = 0;       // current number being built
        int sign = 1;      // current sign (+1 or -1)
        Deque<Integer> st = new ArrayDeque<>(); // stack: [.., prevRes, prevSign]

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
                sign = -1; // handles unary minus too
            } else if (c == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= st.pop();  // sign before '('
                res += st.pop();  // result before '('
            } else if (c == ' ') {
                continue; // ignore spaces
            }
        }

        res += sign * num;
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] tests = {
            "1 + 1",
            " 2-1 + 2 ",
            "(1+(4+5+2)-3)+(6+8)",
        };
    }
}
