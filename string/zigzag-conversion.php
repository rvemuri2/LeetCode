class Solution {

    
    function convert($s, $numRows)
    {
        if ($numRows <= 1 || $numRows >= strlen($s)) {
            return $s;
        }

        $rows = array_fill(0, $numRows, '');
        $curRow = 0;
        $goingDown = false;

        for ($i = 0; $i < strlen($s); $i++) {
            $rows[$curRow] .= $s[$i];
            if ($curRow == 0) {
                $goingDown = true;
            } elseif ($curRow == $numRows - 1) {
                $goingDown = false;
            }
            $curRow += $goingDown ? 1 : -1;
        }
        return implode('', $rows);
    }
}