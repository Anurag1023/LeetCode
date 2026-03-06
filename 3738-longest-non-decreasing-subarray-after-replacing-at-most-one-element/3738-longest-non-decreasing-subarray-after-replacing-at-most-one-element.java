class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {

            ans = Math.max(ans, left[i]);

            if (i == 0) {
                ans = Math.max(ans, 1 + right[1]);
            }
            else if (i == n - 1) {
                ans = Math.max(ans, 1 + left[n - 2]);
            }
            else {
                if (nums[i - 1] <= nums[i + 1]) {
                    ans = Math.max(ans, left[i - 1] + 1 + right[i + 1]);
                } else {
                    ans = Math.max(ans, 1 + Math.max(left[i - 1], right[i + 1]));
                }
            }
        }

        return ans;
    }
}