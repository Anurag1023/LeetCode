class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i = 0; i < graph.length; i++) {
            if(color[i] == -1 && !dfs(graph, color, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int node, int c) {
        color[node] = c;

        for(int nei : graph[node]) {
            if(color[nei] == -1) {
                if(!dfs(graph, color, nei, 1 - c)) return false;
            } 
            else if(color[nei] == c) {
                return false;
            }
        }
        return true;
    }
}