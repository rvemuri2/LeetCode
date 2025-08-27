import java.util.*;

public class Solution {
    /**
     * Wiggle Sort II (in-place, O(n) average time, O(1) extra space).
     *
     * Reorder nums so that: nums[0] < nums[1] > nums[2] < nums[3] ...
     *
     * Idea:
     * 1) Find the median via Quickselect.
     * 2) Three-way partition (Dutch National Flag) around the median,
     *    but place items through a "virtual index" mapping so that
     *    large numbers go to odd positions and small numbers to even.
     *
     * Virtual index mapping:
     *   idx(i) = (1 + 2*i) % (n | 1)
     * This permutes 0..n-1 into an order that interleaves positions:
     *   odd slots first, then even slots, and works for both even/odd n.
     */
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        int median = kthElement(nums, (n - 1) / 2); // 0-based median

        int left = 0;
        int i = 0;
        int right = n - 1;
        while (i <= right) {
            int vi = virtualIndex(i, n);
            if (nums[vi] > median) {
                swap(nums, virtualIndex(left++, n), vi);
                i++;
            } else if (nums[vi] < median) {
                swap(nums, vi, virtualIndex(right--, n));
            } else {
                i++;
            }
        }
    }

    private int virtualIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private int kthElement(int[] a, int k) {
        int l = 0;
        int r = a.length - 1;
        Random rnd = new Random();
        while (l <= r) {
            int p = partition(a, l, r, l + rnd.nextInt(r - l + 1));
            if (p == k) {
                return a[p];
            }
            if (p < k) {
                l = p + 1;
            }
            else {
                r = p - 1;
            }
        }
        return -1;
    }

    private int partition(int[] a, int l, int r, int pivotIdx) {
        int pivot = a[pivotIdx];
        swap(a, pivotIdx, r);
        int store = l;
        for (int i = l; i < r; i++) {
            if (a[i] < pivot) {
                swap(a, store++, i);
            }
        }
        swap(a, store, r);
        return store;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int t = a[i]; 
        a[i] = a[j]; 
        a[j] = t;
    }

    private static boolean isWiggle(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (i % 2 == 1) {
                if (!(a[i] > a[i-1])) return false;
            } else {
                if (!(a[i] < a[i-1])) return false;
            }
        }
        return true;
    }
}