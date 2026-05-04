class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[py] = px;
            }
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int total = n * n;

        // Step 1: store all cells → {height, row, col}
        int[][] cells = new int[total][3];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[idx++] = new int[]{grid[i][j], i, j};
            }
        }

        // Step 2: sort by height
        Arrays.sort(cells, (a, b) -> a[0] - b[0]);

        DSU dsu = new DSU(total);
        boolean[][] active = new boolean[n][n];

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        // Step 3: activate cells in increasing height
        for (int[] cell : cells) {
            int h = cell[0];
            int x = cell[1];
            int y = cell[2];

            active[x][y] = true;

            // connect with active neighbors
            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && active[nx][ny]) {
                    int id1 = x * n + y;
                    int id2 = nx * n + ny;
                    dsu.union(id1, id2);
                }
            }

            // check if start and end are connected
            if (dsu.find(0) == dsu.find(n * n - 1)) {
                return h;
            }
        }

        return -1; // should never happen
    }
}