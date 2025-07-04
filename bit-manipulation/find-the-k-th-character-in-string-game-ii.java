class Solution {
    public char kthCharacter(long k, int[] operations) {
        // Initially, word length is 1 ('a')
        long len = 1;

        // First, compute final length after all operations
        for (int op : operations) {
            if (op == 0) {
                len *= 2; // double the length
            } else {
                len *= 2; // also doubles length in this operation
            }
        }

        // Process operations backwards to find kth character efficiently
        for (int i = operations.length - 1; i >= 0; i--) {
            len /= 2; // Each operation doubled the string, so reverse it

            if (k > len) {
                // If k is in the appended half, adjust it
                k -= len;

                // For operation type 1, shift character back by -1 (since it was next char)
                if (operations[i] == 1) {
                    // When we go backwards, we reverse the increment
                    // But if character is 'a' originally, it was 'z' in operation
                    // So we adjust it here later
                }
            }
        }

        // At the end, the character is based on how many type-1 operations we crossed on its path
        // Count total type-1 operations on its path
        int shift = 0;
        for (int op : operations) {
            if (op == 1) shift++;
        }

        // Adjust character 'a' shifted by number of type-1 operations mod 26
        char res = (char) ('a' + (shift % 26));
        if (res > 'z') res -= 26;

        return res;
    }

    // Main to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.kthCharacter(5, new int[]{0,0,0})); // Output: "a"
        System.out.println(sol.kthCharacter(10, new int[]{0,1,0,1})); // Output: "b"
        System.out.println(sol.kthCharacter(1, new int[]{1,1,1,1})); // Output: "e"
    }
}
