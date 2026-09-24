class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return nums.length;
        }

        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);

        int sum = 0;
        int maxLen = -1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (hm.containsKey(sum - target)) {
                maxLen = Math.max(maxLen, i - hm.get(sum - target));
            }

            // Keep the earliest index
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}