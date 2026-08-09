class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> hs = new HashMap<>();

        helper(0, arr, res, hs, nums, k);

        return res.size() - 1;
    }

    private void helper(int ind, List<Integer> arr,
            List<List<Integer>> res,
            Map<Integer, Integer> hs,
            int[] nums, int k) {

        if (ind == nums.length) {
            res.add(new ArrayList<>(arr));
            return;
        }

        if (!hs.containsKey(nums[ind] + k) &&
            !hs.containsKey(nums[ind] - k)) {

            arr.add(nums[ind]);

            hs.put(nums[ind], hs.getOrDefault(nums[ind], 0) + 1);

            helper(ind + 1, arr, res, hs, nums, k);

            arr.remove(arr.size() - 1);

            int count = hs.get(nums[ind]);

            if (count == 1) {
                hs.remove(nums[ind]);
            } else {
                hs.put(nums[ind], count - 1);
            }
        }

        helper(ind + 1, arr, res, hs, nums, k);
    }
}