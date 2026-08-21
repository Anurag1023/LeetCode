class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(i, vis, isConnected);
                ans++;
            }
        }

        return ans;
    }

    private void bfs(int i, boolean[] vis, int[][] isConnected) {

        vis[i] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(i);

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neigh = 0; neigh < isConnected.length; neigh++) {

                if (isConnected[node][neigh] == 1 && !vis[neigh]) {
                    q.offer(neigh);
                    vis[neigh] = true;
                }
            }
        }
    }
}