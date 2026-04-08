class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int)1e9);

        dist[k] = 0;
        q.offer(new int[]{0, k});

        while(!q.isEmpty()){
            int[] data = q.poll();
            int weight = data[0];
            int node = data[1];

            if(weight > dist[node]) continue;

            for(int[] nei : adj.get(node)){
                int nextNode = nei[0];
                int time = nei[1];

                if(weight + time < dist[nextNode]){
                    dist[nextNode] = weight + time;
                    q.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == (int)1e9) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}