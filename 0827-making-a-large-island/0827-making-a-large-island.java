class Solution {

    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return;

            // union by size
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }

        int getSize(int x) {
            return size[find(x)];
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        // Step 1: connect all 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    for (int[] d : dir) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 1) {
                            dsu.union(i * n + j, ni * n + nj);
                        }
                    }
                }
            }
        }

        int max = 0;
        boolean hasZero = false;

        // Step 2: try flipping each 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    hasZero = true;
                    Set<Integer> set = new HashSet<>();

                    for (int[] d : dir) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 1) {
                            set.add(dsu.find(ni * n + nj));
                        }
                    }

                    int size = 1;
                    for (int parent : set) {
                        size += dsu.size[parent];
                    }

                    max = Math.max(max, size);
                }
            }
        }

        if (!hasZero) return n * n;

        return max;
    }
}