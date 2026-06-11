class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();

        for (List<Integer> row : triangle) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < row.size(); i++) {
                temp.add(null);
            }
            dp.add(temp);
        }

        return helper(triangle, 0, 0, dp);
    }

    private int helper(List<List<Integer>> tri, int y, int level, List<List<Integer>> dp) {

        if (level == tri.size() - 1)
            return tri.get(level).get(y);

        if (dp.get(level).get(y) != null)
            return dp.get(level).get(y);

        dp.get(level).set(y,
                tri.get(level).get(y) + Math.min(helper(tri, y, level + 1, dp), helper(tri, y + 1, level + 1, dp)));

        return dp.get(level).get(y);
    }
}