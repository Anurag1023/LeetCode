class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        List<List<Integer>> rev = new ArrayList<>();
        int[] indegree = new int[v];

        for(int i=0;i<v;i++){
            rev.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int it: graph[i]){
                rev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<v;i++){
            if(indegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node =q.poll();
            for(int nei: rev.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0) q.offer(nei);
            }
            res.add(node);
        }

        Collections.sort(res);

        return res;
    }
}