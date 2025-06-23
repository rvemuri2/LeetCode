class Solution {
    public int longestValidParentheses(String s) {
        // Stack to store indices
        Stack<Integer> stack = new Stack<>();
        // Initialize with -1 to handle base case for first valid substring
        stack.push(-1);
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // Push index of '(' onto the stack
                stack.push(i);
            } else {
                // Pop the last open bracket's index
                stack.pop();
                
                if (stack.isEmpty()) {
                    // If the stack is empty, push current index as base for future matches
                    stack.push(i);
                } else {
                    // Current valid substring length = i - index at stack top
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    // Test cases
    public static void main(String[] args) {}
}