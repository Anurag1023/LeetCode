class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        // Build graph
        for (int[] pre : prerequisites)
            adj.get(pre[1]).add(pre[0]);

        int[] state = new int[numCourses];
        // 0 = unvisited
        // 1 = visiting
        // 2 = visited

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(adj, state, i))
                    return false;
            }
        }

        return true;
    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int[] state, int node) {

        state[node] = 1; // visiting

        for (int neighbor : adj.get(node)) {

            if (state[neighbor] == 1)
                return true; // cycle found

            if (state[neighbor] == 0) {
                if (hasCycle(adj, state, neighbor))
                    return true;
            }
        }

        state[node] = 2; // done
        return false;
    }
}
