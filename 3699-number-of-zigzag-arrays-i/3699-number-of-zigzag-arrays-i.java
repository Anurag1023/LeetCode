class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2
        for (int y = 0; y < m; y++) {
            up[y] = y;              // x < y
            down[y] = m - 1 - y;   // x > y
        }

        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long pref = 0;
            for (int y = 0; y < m; y++) {
                newUp[y] = pref;
                pref = (pref + down[y]) % MOD;
            }

            long suff = 0;
            for (int y = m - 1; y >= 0; y--) {
                newDown[y] = suff;
                suff = (suff + up[y]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }
        
        return (int) ans;
    }
}