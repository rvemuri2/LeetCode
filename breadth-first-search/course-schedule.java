import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build graph and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Step 2: Initialize queue with courses having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        // Step 3: Process courses
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        // Step 4: Check if all courses are completed
        return completedCourses == numCourses;
    }
    public static void main(String[] args) {
    Solution sol = new Solution();

    int[][] prereq1 = {{1, 0}};
    System.out.println(sol.canFinish(2, prereq1)); // true

    int[][] prereq2 = {{1, 0}, {0, 1}};
    System.out.println(sol.canFinish(2, prereq2)); // false

    int[][] prereq3 = {};
    System.out.println(sol.canFinish(3, prereq3));
}

}
