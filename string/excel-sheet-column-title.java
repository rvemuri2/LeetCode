public class Solution {

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
