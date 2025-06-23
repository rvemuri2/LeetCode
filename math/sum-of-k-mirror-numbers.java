class Solution {
    // Check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    // Convert a number to a string in base-k
    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    // Generate palindromes in base-10 and check base-k validity
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            for (int half = (int) Math.pow(10, (len - 1) / 2); count < n && half < (int) Math.pow(10, (len + 1) / 2); half++) {
                // Generate palindromes from the half number
                String firstHalf = String.valueOf(half);
                String palindromeStr = firstHalf + new StringBuilder(firstHalf.substring(0, len % 2 == 0 ? firstHalf.length() : firstHalf.length() - 1)).reverse();
                long palindromeNum = Long.parseLong(palindromeStr);

                if (isPalindrome(toBaseK(palindromeNum, k))) {
                    sum += palindromeNum;
                    count++;
                }
            }
            len++;
        }

        return sum;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.kMirror(2, 5));
    }
}