class Solution {
    public double[] convertTemperature(double celsius) {
        // Formula for Kelvin: Celsius + 273.15
        double kelvin = celsius + 273.15;

        // Formula for Fahrenheit: Celsius * 1.80 + 32.00
        double fahrenheit = celsius * 1.80 + 32.00;

        // Return as an array [kelvin, fahrenheit]
        return new double[]{kelvin, fahrenheit};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        double[] res1 = sol.convertTemperature(36.50);
        System.out.printf("[%.5f,%.5f]%n", res1[0], res1[1]); // [309.65000,97.70000]

        double[] res2 = sol.convertTemperature(122.11);
        System.out.printf("[%.5f,%.5f]%n", res2[0], res2[1]); // [395.26000,251.79800]
    }
}
