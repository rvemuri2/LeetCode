class Solution {
    public double[] convertTemperature(double celsius) {
        // Formula for Kelvin: Celsius + 273.15
        double kelvin = celsius + 273.15;

        // Formula for Fahrenheit: Celsius * 1.80 + 32.00
        double fahrenheit = celsius * 1.80 + 32.00;

        // Return as an array [kelvin, fahrenheit]
        return new double[]{kelvin, fahrenheit};
    }
}
