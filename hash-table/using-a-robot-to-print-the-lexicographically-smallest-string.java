class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minSuffix = new char[n + 1];
        minSuffix[n] = '{';
        for (int i = n - 1; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(s.charAt(i), minSuffix[i + 1]);
        }

        StringBuilder output = new StringBuilder();
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            stack.append(s.charAt(i));
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