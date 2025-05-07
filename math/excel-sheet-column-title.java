public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.convertToTitle(1));    // Output: "A"
        System.out.println(sol.convertToTitle(28));   // Output: "AB"
        System.out.println(sol.convertToTitle(701));  // Output: "ZY"
        System.out.println(sol.convertToTitle(702));  // Output: "ZZ"
        System.out.println(sol.convertToTitle(703)); 
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            char letter = (char) ('A' + remainder);
            result.append(letter);
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}
