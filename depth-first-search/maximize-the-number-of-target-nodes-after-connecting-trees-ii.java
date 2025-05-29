import java.util.*;

public class Solution {
    /**
     * For each node i in the first tree, we connect i to one optimal node in the second tree to
     * maximize the number of "target" nodes (even-distance) from i in the combined tree.
     * In a tree, distance parity from i to x depends only on the parity of depths in a fixed root BFS.
     */
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        // Build adjacency lists
        List<List<Integer>> tree1 = buildGraph(n, edges1);
        List<List<Integer>> tree2 = buildGraph(m, edges2);

        // BFS from node 0 to determine depth parity partitions in tree1
        int[] depth1 = bfsDepth(tree1, 0);
        int countEven1 = 0;
        for (int d : depth1) if ((d & 1) == 0) countEven1++;
        int countOdd1  = n - countEven1;

        // BFS from node 0 to determine depth parity partitions in tree2
        int[] depth2 = bfsDepth(tree2, 0);
        int countEven2 = 0;
        for (int d : depth2) if ((d & 1) == 0) countEven2++;
        int countOdd2  = m - countEven2;

        // When connecting i to some j, a node x in tree1 is at even distance from i
        // iff depth1[x] % 2 == depth1[i] % 2 → countEven1 or countOdd1 accordingly.
        // A node y in tree2 is at even total distance from i when 1 + dist2(j,y) is even → dist2(j,y) odd.
        // Among all j, the maximum odd-distance node count equals max(countEven2, countOdd2).
        int maxOdd2 = Math.max(countEven2, countOdd2);

        // Build answer: for each i, its even-count in tree1 + max odd-count in tree2
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int evenCountFromI = ((depth1[i] & 1) == 0) ? countEven1 : countOdd1;
            answer[i] = evenCountFromI + maxOdd2;
        }
        return answer;
    }

    // Build undirected graph
    private List<List<Integer>> buildGraph(int size, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < size; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        return g;
    }

    // Standard BFS to compute depth from root
    private int[] bfsDepth(List<List<Integer>> graph, int root) {
        int n = graph.size();
        int[] depth = new int[n];
        Arrays.fill(depth, -1);
        Queue<Integer> q = new LinkedList<>();
        depth[root] = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (depth[v] == -1) {
                    depth[v] = depth[u] + 1;
                    q.offer(v);
                }
            }
        }
        return depth;
    }

    // Optional test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
    }
}