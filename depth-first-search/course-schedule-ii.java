import java.util.*;

class Solution {
    /**
     * Topological sort (Kahn's BFS) to produce a valid course order.
     * Build graph edges bi -> ai (to take ai you must first take bi),
     * compute indegrees, push all nodes with indegree 0, and repeatedly pop
     * and relax outgoing edges. If we process all courses, we have a valid order;
     * otherwise a cycle exists -> return empty array.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Adjacency list: from -> list of to
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        
        // Indegree array
        int[] indeg = new int[numCourses];
        for (int[] p : prerequisites) {
            int a = p[0], b = p[1]; // b -> a
            graph.get(b).add(a);
            indeg[a]++;
        }
        
        // Queue of courses with no prerequisites
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indeg[i] == 0) q.offer(i);
        
        int[] order = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : graph.get(u)) {
                if (--indeg[v] == 0) q.offer(v);
            }
        }
        
        // If we couldn't schedule all courses, a cycle exists
        if (idx != numCourses) return new int[0];
        return order;
    }
}