class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        long[] prefSum = new long[n + 1];
        int[] cnt = new int[n + 1];
        long[] prefNum = new long[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;

        for (int i = 0; i < n; i++) {
            pow10[i + 1] = (pow10[i] * 10) % MOD;

            int d = s.charAt(i) - '0';

            prefSum[i + 1] = prefSum[i];
            cnt[i + 1] = cnt[i];
            prefNum[i + 1] = prefNum[i];

            if (d != 0) {
                prefSum[i + 1] += d;
                cnt[i + 1]++;
                prefNum[i + 1] = (prefNum[i] * 10 + d) % MOD;
            }
        }

        // prefNum at each non-zero count
        long[] valueAtCnt = new long[cnt[n] + 1];
        int idx = 0;
        valueAtCnt[0] = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                idx++;
                valueAtCnt[idx] = prefNum[i + 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefSum[r + 1] - prefSum[l];

            int leftCnt = cnt[l];
            int rightCnt = cnt[r + 1];
            int len = rightCnt - leftCnt;

            long num = (prefNum[r + 1]
                    - valueAtCnt[leftCnt] * pow10[len] % MOD
                    + MOD) % MOD;

            ans[i] = (int) (num * (sum % MOD) % MOD);
        }

        return ans;
    }
}