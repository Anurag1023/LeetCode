class Solution {
    public int countPalindromes(String s) {
        int n = s.length();
        int MOD = 1_000_000_007;

        // left[i][a][b]: count of pair ab before index i
        // right[i][a][b]: count of pair ab after index i
        int[][][] left = new int[n][10][10];
        int[][][] right = new int[n][10][10];

        int[] freq = new int[10];

        // Build prefix pair counts
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            if (i > 0) {
                for (int a = 0; a < 10; a++) {
                    System.arraycopy(
                        left[i - 1][a], 0, left[i][a], 0, 10
                    );
                }
            }

            for (int a = 0; a < 10; a++) {
                left[i][a][d] += freq[a];
            }

            freq[d]++;
        }

        // Build suffix pair counts
        freq = new int[10];

        for (int i = n - 1; i >= 0; i--) {
            int d = s.charAt(i) - '0';

            if (i < n - 1) {
                for (int a = 0; a < 10; a++) {
                    System.arraycopy(
                        right[i + 1][a], 0, right[i][a], 0, 10
                    );
                }
            }

            for (int b = 0; b < 10; b++) {
                right[i][d][b] += freq[b];
            }

            freq[d]++;
        }

        long ans = 0;

        // Choose the middle character
        for (int i = 2; i < n - 2; i++) {
            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {
                    long l = left[i - 1][a][b];
                    long r = right[i + 1][b][a];

                    ans = (ans + l * r) % MOD;
                }
            }
        }

        return (int) ans;
    }
}