class Solution {
    public int minimumPossibleSum(int n, int target) {
        long mod = 1_000_000_007;

        long k = Math.min(n, target / 2);

        // 1 + 2 + ... + k
        long ans = k * (k + 1) / 2;

        // Remaining numbers: target, target + 1, ...
        long remaining = n - k;

        ans += remaining * (2L * target + remaining - 1) / 2;

        return (int) (ans % mod);
    }
}