class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int[] it: prerequisites){
            adj.get(it[1]).add(it[0]);
            indegree[it[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<numCourses;i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int nei: adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.offer(nei);
                }
            }

            res.add(node);
        }

        if(res.size()!=numCourses) return new int[0];

        int[] ans = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}