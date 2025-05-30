import java.util.*;

public class Solution {
    /**
     * Finds the closest meeting node reachable from both node1 and node2 in a directed graph
     * where each node has at most one outgoing edge.
     * We compute distances from node1 and node2 separately, then choose the node minimizing
     * the maximum of the two distances, breaking ties by smaller node index.
     *
     * @param edges Directed edges representation; edges[i] = next node or -1 if none
     * @param node1 Starting node for first distance
     * @param node2 Starting node for second distance
     * @return The index of the closest meeting node, or -1 if none exists
     */
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = computeDistances(edges, node1, n);
        int[] dist2 = computeDistances(edges, node2, n);

        int answer = -1;
        int bestMaxDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                // select smaller maxDist or smaller index on tie
                if (maxDist < bestMaxDist || (maxDist == bestMaxDist && i < answer)) {
                    bestMaxDist = maxDist;
                    answer = i;
                }
            }
        }

        return answer;
    }

    /**
     * Computes shortest distance from start to every node in the functional graph
     * where each node has at most one outgoing edge.
     * Uses simple traversal since outdegree ≤ 1.
     *
     * @param edges Graph edges
     * @param start Starting node
     * @param n Number of nodes
     * @return dist array where dist[i] is distance from start to i, or -1 if unreachable
     */
    private int[] computeDistances(int[] edges, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int node = start;
        int d = 0;
        // Traverse until end or cycle
        while (node != -1 && dist[node] == -1) {
            dist[node] = d;
            d++;
            node = edges[node];
        }
        return dist;
    }

    // Optional: test runner
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] edges1 = {2, 2, 3, -1};
        System.out.println(sol.closestMeetingNode(edges1, 0, 1)); // Expected 2

        int[] edges2 = {1, 2, -1};
        System.out.println(sol.closestMeetingNode(edges2, 0, 2)); // Expected 2

        int[] edges3 = {4, 4, 4, 5, 2, 3, 1};

    }
}