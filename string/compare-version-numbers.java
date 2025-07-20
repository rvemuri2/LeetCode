class Solution {
    /**
     * Compares two version strings.
     * @param version1 First version string.
     * @param version2 Second version string.
     * @return -1 if version1 < version2, 1 if version1 > version2, 0 if equal.
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        System.out.println("Test 1: " + sol.compareVersion("1.2", "1.10"));  // -1

        // Test Case 2
        System.out.println("Test 2: " + sol.compareVersion("1.01", "1.001"));  // 0

        // Test Case 3
        System.out.println("Test 3: " + sol.compareVersion("1.0", "1.0.0.0"));  // 0
    }
}