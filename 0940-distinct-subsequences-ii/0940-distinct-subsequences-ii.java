class Solution {
    long mod = 1000000007;

    public int distinctSubseqII(String s) {

        long total = 0;
        long[] last = new long[26];

        for (char ch : s.toCharArray()) {

            int c = ch - 'a';

            long newSubseq = (total + 1) % mod;

            total = (total + newSubseq - last[c] + mod) % mod;

            last[c] = newSubseq;
        }

        return (int) total;
    }
}