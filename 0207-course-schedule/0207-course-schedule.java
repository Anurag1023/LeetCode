class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int[] it: prerequisites){
            adj.get(it[1]).add(it[0]);
            indegree[it[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res =  new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.offer(it);
            }

            res.add(node);
        }

        return res.size()==numCourses;
    }
}