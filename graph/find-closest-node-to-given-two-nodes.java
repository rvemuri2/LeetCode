public class Solution {
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = computeDistances(edges, node1, n);
        int[] dist2 = computeDistances(edges, node2, n);

        int answer = -1;
        int bestMaxDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < bestMaxDist || (maxDist == bestMaxDist && i < answer)) {
                    bestMaxDist = maxDist;
                    answer = i;
                }
            }
        }

        return answer;
    }

    private int[] computeDistances(int[] edges, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int node = start;
        int d = 0;

        while (node != -1 && dist[node] == -1) {
            dist[node] = d;
            d++;
            node = edges[node];
        }
        return dist;
    }
}