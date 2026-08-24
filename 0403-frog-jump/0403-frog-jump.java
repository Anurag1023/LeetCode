class Solution {
    Map<String, Boolean> dp = new HashMap<>();

    public boolean canCross(int[] stones) {
        return helper(stones, 0, 0);
    }

    private boolean helper(int[] stones, int k, int i) {

        if (i == stones.length - 1) {
            return true;
        }

        String key = i + "," + k;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        boolean ans = false;

        int j = i + 1;

        while (j < stones.length &&
               stones[j] - stones[i] <= k + 1) {

            int jump = stones[j] - stones[i];

            if (jump >= k - 1 && jump <= k + 1) {
                ans = ans || helper(stones, jump, j);
            }

            j++;
        }

        dp.put(key, ans);
        return ans;
    }
}