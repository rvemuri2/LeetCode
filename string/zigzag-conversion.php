class Solution {

    /**
     * @param String $s
     * @param Integer $numRows
     * @return String
     */
    function convert($s, $numRows)
    {
        // If numRows is 1 or greater than or equal to the length of the string, return the string itself
        if ($numRows <= 1 || $numRows >= strlen($s)) {
            return $s;
        }

        // Create an array to hold the strings for each row
        $rows = array_fill(0, $numRows, '');
        $curRow = 0;
        $goingDown = false;

        // Iterate through each character in the string
        for ($i = 0; $i < strlen($s); $i++) {
            $rows[$curRow] .= $s[$i]; // Append the character to the current row
            // Change direction if we hit the top or bottom row
            if ($curRow == 0) {
                $goingDown = true;
            } elseif ($curRow == $numRows - 1) {
                $goingDown = false;
            }
            // Move to the next row
            $curRow += $goingDown ? 1 : -1;
        }
        return implode('', $rows);
    }
}