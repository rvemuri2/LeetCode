class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = n - mid;

            if (citations[mid] >= h) {
                result = h;
                right = mid - 1; // try for a better (smaller) index
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
