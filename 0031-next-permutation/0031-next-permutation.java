class Solution {
    public void nextPermutation(int[] nums) {
        int dip = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                dip = i;
                break;
            }
        }

        if (dip == -1) {
            int left = 0, right = n - 1;

            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        } else {

            for (int i = n - 1; i > dip; i--) {
                if (nums[i] > nums[dip]) {
                    int temp = nums[i];
                    nums[i] = nums[dip];
                    nums[dip] = temp;
                    break;
                }
            }

            int left = dip + 1;
            int right = n - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}