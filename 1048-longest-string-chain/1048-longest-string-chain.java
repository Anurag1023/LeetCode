class Solution {

    public int longestStrChain(String[] words) {

        int n = words.length;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (words[i].length() != words[j].length() + 1)
                    continue;

                if (check(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    private boolean check(String smaller, String bigger) {

        int i = 0;
        int j = 0;

        while (i < smaller.length() && j < bigger.length()) {

            if (smaller.charAt(i) == bigger.charAt(j)) {
                i++;
            }

            j++;
        }

        return i == smaller.length();
    }
}