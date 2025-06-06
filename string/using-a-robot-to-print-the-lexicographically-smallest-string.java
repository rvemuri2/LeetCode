class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        // minSuffix[i] = smallest character in s[i..n-1]; minSuffix[n] = '{' (beyond 'z')
        char[] minSuffix = new char[n + 1];
        minSuffix[n] = '{';
        for (int i = n - 1; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(s.charAt(i), minSuffix[i + 1]);
        }

        StringBuilder output = new StringBuilder();
        // Use StringBuilder as stack t: append = push, deleteCharAt(len-1) = pop
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // Push s[i] onto t
            stack.append(s.charAt(i));
            // While t not empty and its top ≤ minSuffix[i+1], pop to output
            while (stack.length() > 0 && stack.charAt(stack.length() - 1) <= minSuffix[i + 1]) {
                output.append(stack.charAt(stack.length() - 1));
                stack.deleteCharAt(stack.length() - 1);
            }
        }

        while (stack.length() > 0) {
            output.append(stack.charAt(stack.length() - 1));
            stack.deleteCharAt(stack.length() - 1);
        }

        return output.toString();
    }
}