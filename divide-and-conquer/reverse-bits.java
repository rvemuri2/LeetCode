public class Solution {
    // you need to treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        // Loop through 32 bits of the integer
        for (int i = 0; i < 32; i++) {
            // Shift result to the left to make room for the next bit
            result <<= 1;

            result |= (n & 1);

            n >>= 1;
        }

        return result;
    }
}
