class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        // Multi-source BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;

                if (dist[nr][nc] != -1)
                    continue;

                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[][] best = new int[n][n];
        for (int[] row : best)
            Arrays.fill(row, -1);

        best[0][0] = dist[0][0];
        pq.offer(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int safe = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (r == n - 1 && c == n - 1)
                return safe;

            if (safe < best[r][c])
                continue;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;

                int nextSafe = Math.min(safe, dist[nr][nc]);

                if (nextSafe > best[nr][nc]) {
                    best[nr][nc] = nextSafe;
                    pq.offer(new int[]{nextSafe, nr, nc});
                }
            }
        }

        return 0;
    }
}