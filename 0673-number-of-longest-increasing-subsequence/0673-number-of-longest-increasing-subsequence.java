class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] len = new int[n];
        int[] count = new int[n];

        Arrays.fill(len, 1);
        Arrays.fill(count, 1);

        int maxLen = 1;
        int ans = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    // Found a longer LIS ending at i
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }

                    // Found another LIS of the same maximum length
                    else if (len[j] + 1 == len[i]) {
                        count[i] += count[j];
                    }
                }
            }

            // New overall maximum length
            if (len[i] > maxLen) {
                maxLen = len[i];
                ans = count[i];
            }

            // Another LIS having the overall maximum length
            else if (len[i] == maxLen) {
                ans += count[i];
            }
        }

        return ans;
    }
}