// This shit humbled me, CTRL + C

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        int size = 2 * m;

        // Base state for length = 2
        long[] base = new long[size];
        for (int i = 0; i < m; i++) {
            base[i] = i;               // up[i]
            base[m + i] = m - 1 - i;  // down[i]
        }

        if (n == 2) {
            long ans = 0;
            for (long x : base) {
                ans = (ans + x) % MOD;
            }
            return (int) ans;
        }

        // Build transition matrix
        long[][] T = new long[size][size];

        for (int y = 0; y < m; y++) {

            // newUp[y] = sum(down[x]) for x < y
            for (int x = 0; x < y; x++) {
                T[y][m + x] = 1;
            }

            // newDown[y] = sum(up[x]) for x > y
            for (int x = y + 1; x < m; x++) {
                T[m + y][x] = 1;
            }
        }

        long[][] P = power(T, n - 2);

        long[] finalState = multiply(P, base);

        long ans = 0;
        for (long x : finalState) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[][] power(long[][] mat, long exp) {
        int n = mat.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, mat);
            }

            mat = multiply(mat, mat);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long a = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + a * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;

            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;

                cur = (cur + A[i][j] * v[j]) % MOD;
            }

            res[i] = cur;
        }

        return res;
    }
}