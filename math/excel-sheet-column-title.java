public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.convertToTitle(1));    // Output: "A"
        System.out.println(sol.convertToTitle(28));   // Output: "AB"
        System.out.println(sol.convertToTitle(701));  // Output: "ZY"
        System.out.println(sol.convertToTitle(702));  // Output: "ZZ"
        System.out.println(sol.convertToTitle(703));  // Output: "AAA"
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        // Repeat until columnNumber is reduced to 0
        while (columnNumber > 0) {
            columnNumber--; // Adjust to 0-based (A=0, ..., Z=25)
            int remainder = columnNumber % 26;
            char letter = (char) ('A' + remainder); // Convert to character
            result.append(letter);
            columnNumber /= 26; // Move to next digit
        }

        return result.reverse().toString();
    }
}
