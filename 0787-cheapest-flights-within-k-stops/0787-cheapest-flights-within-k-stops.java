class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0}); // {node, cost}
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        int stops = 0;
        
        while(!q.isEmpty() && stops <= k) {
            int size = q.size();
            
            int[] temp = dist.clone();
            
            while(size-- > 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int cost = curr[1];
                
                for(int[] nei : adj.get(node)) {
                    int next = nei[0];
                    int price = nei[1];
                    
                    if(cost + price < temp[next]) {
                        temp[next] = cost + price;
                        q.offer(new int[]{next, temp[next]});
                    }
                }
            }
            
            dist = temp;
            stops++;
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}