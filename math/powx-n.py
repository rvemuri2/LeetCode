class Solution:
    def myPow(self, x: float, n: int) -> float:
         # Handle the case when n is negative by converting it to positive
    # and inverting x
        if n < 0:
            x = 1 / x
            n = -n

        result = 1
        current_product = x

    # Use exponentiation by squaring for efficiency (log(n) time)
        while n > 0:

            if n % 2 == 1:
                result *= current_product

            current_product *= current_product
            n //= 2

        return result
        