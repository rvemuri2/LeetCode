class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function myAtoi($s) {
        $a = (int)str_replace('e', 'a', $s);
        if ($a > 2**31 - 1) {
            return 2**31 - 1;
        } 
        if ($a < -2**31) return -2**31;
        return $a;
    }
}