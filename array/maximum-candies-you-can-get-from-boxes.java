import java.util.*;

public class Solution {
    /**
     * Returns the maximum number of candies collectable by opening boxes according to the rules:
     * - You initially have the boxes in initialBoxes.
     * - A box i can be opened if status[i] == 1 (already open) or you hold a key for i.
     * - Opening box i yields candies[i], provides all keys[i], and reveals containedBoxes[i].
     * - You may open any newly available boxes as soon as both (a) you “have” them and (b) they are openable.
     */
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        // Track which boxes we currently “have” in hand.
        boolean[] haveBox = new boolean[n];
        // Track which keys we hold for each box.
        boolean[] haveKey = new boolean[n];
        // Track which boxes have already been opened (so we don’t double-count).
        boolean[] opened = new boolean[n];
        // BFS queue for any box that is currently in-hand and openable.
        Queue<Integer> queue = new LinkedList<>();

        // 1) Mark all initial boxes as “in hand.”
        for (int b : initialBoxes) {
            haveBox[b] = true;
        }

        // 2) Among those initial boxes, enqueue any that are already open (status[b] == 1).
        for (int b : initialBoxes) {
            if (status[b] == 1) {
                queue.offer(b);
            }
        }

        int totalCandies = 0;

        // 3) Process the queue until no more openable boxes remain.
        while (!queue.isEmpty()) {
            int box = queue.poll();
            // If we already opened it, skip.
            if (opened[box]) continue;

            // Open this box now.
            opened[box] = true;
            totalCandies += candies[box];

            // 3a) Collect all keys from this box. 
            for (int k : keys[box]) {
                if (!haveKey[k]) {
                    haveKey[k] = true;
                    // If we already “have” box k in hand, it’s now openable → enqueue.
                    if (haveBox[k] && !opened[k]) {
                        queue.offer(k);
                    }
                }
            }

            // 3b) Collect all contained boxes from this box.
            for (int cb : containedBoxes[box]) {
                if (!haveBox[cb]) {
                    haveBox[cb] = true;
                    // If this newly acquired box is already openable (status[cb]==1 or haveKey[cb]),
                    // enqueue it now.
                    if ((status[cb] == 1 || haveKey[cb]) && !opened[cb]) {
                        queue.offer(cb);
                    }
                }
            }
        }

        return totalCandies;
    }

    // Optional main method for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] status1 = {1, 0, 1, 0};
        int[] candies1 = {7, 5, 4, 100};
        int[][] keys1 = {
            {},     // box 0 has no keys
            {},     // box 1 has no keys
            {1},    // box 2 gives key to box 1
            {}      // box 3 has no keys
        };
        int[][] contained1 = {
            {1, 2}, // box 0 contains boxes 1 and 2
            {3},    // box 1 contains box 3
            {},     // box 2 contains none
        };
        int[] init1 = {0};
    }
}