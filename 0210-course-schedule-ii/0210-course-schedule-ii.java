class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            graph.get(p[1]).add(p[0]);
        }

        int[] state = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            if(state[i] == 0){
                if(!dfs(i, graph, state, result)){
                    return new int[0];
                }
            }
        }

        Collections.reverse(result);

        int[] ans = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            ans[i] = result.get(i);
        }

        return ans;
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] state, List<Integer> result){
        // 0 = unvisited
        // 1 = visiting
        // 2 = visited
        if(state[node] == 1) return false; // cycle
        if(state[node] == 2) return true;

        state[node] = 1;

        for(int next : graph.get(node)){
            if(!dfs(next, graph, state, result)){
                return false;
            }
        }

        state[node] = 2;
        result.add(node);

        return true;
    }
}