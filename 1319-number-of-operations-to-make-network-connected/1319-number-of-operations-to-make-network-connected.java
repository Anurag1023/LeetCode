class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] conn : connections) {
            graph.get(conn[0]).add(conn[1]);
            graph.get(conn[1]).add(conn[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                components++;
            }
        }

        return components - 1;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(graph, visited, nei);
            }
        }
    }
}