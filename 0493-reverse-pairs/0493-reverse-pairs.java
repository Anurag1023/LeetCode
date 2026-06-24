class Solution {
    private int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        countPairs(nums, l, mid, r);
        merge(nums, l, mid, r);
    }

    private void countPairs(int[] nums, int l, int mid, int r) {
        int j = mid + 1;

        for (int i = l; i <= mid; i++) {
            while (j <= r && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];

        int i = l, j = mid + 1, k = 0;

        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= r) temp[k++] = nums[j++];

        for (int p = 0; p < temp.length; p++) {
            nums[l + p] = temp[p];
        }
    }
}