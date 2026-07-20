class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return Subarrays(nums, k) - Subarrays(nums, k - 1);
    }

    public int Subarrays(int[] nums, int k) {

        if (k < 0)
            return 0;

        int l = 0;
        int cnt = 0;
        int sum = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 != 0) {
                sum++;
            }

            while (sum > k) {
                if (nums[l] % 2 != 0) {
                    sum--;
                }
                l++;
            }

            cnt += r-l+1;
        }
        return cnt;
    }
}