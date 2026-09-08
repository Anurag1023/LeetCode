class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used);

        return ans;
    }

    private void backtrack(int[] nums, boolean[] used) {

        // Base case
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Already used
            if (used[i]) {
                continue;
            }

            // Skip duplicate at same level
            if (i > 0 &&
                nums[i] == nums[i - 1] &&
                !used[i - 1]) {
                continue;
            }

            // Choose
            curr.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(nums, used);

            // Undo
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}