/*If curr == 0 → count = high × position

 */

class Solution {
    public int countDigitOne(int n) {
        int b = n;
        int count = 0;
        int total = 0;

        while (b != 0) {
            int position = (int)Math.pow(10, count); 
            int curr = (n / position) % 10;           

            count++;

            int a = count;
            int mul = 1;

            while (a != 0) {  
                mul = mul * 10;
                a--;
            }

            int left = n / mul;        
            int right = n % position;  

            if (curr == 0) {

                total += left * position;

            } else if (curr == 1) {

                total += (left * position) + (right + 1);

            } else if (curr > 1) {
                total += (left + 1) * position;
            }

            b = b / 10;   
        }
        return total;
    }
}