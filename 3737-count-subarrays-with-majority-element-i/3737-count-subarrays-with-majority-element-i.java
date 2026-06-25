class Solution {

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int val = (nums[i] == target) ? 1 : -1;
            prefix[i + 1] = prefix[i] + val;
        }

        return mergeSort(prefix, 0, n);
    }

    private int mergeSort(long[] prefix, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;

        int ans = 0;

        ans += mergeSort(prefix, left, mid);
        ans += mergeSort(prefix, mid + 1, right);

        // Count pairs
        int i = left;
        for (int j = mid + 1; j <= right; j++) {
            while (i <= mid && prefix[i] < prefix[j]) {
                i++;
            }
            ans += i - left;
        }

        merge(prefix, left, mid, right);

        return ans;
    }

    private void merge(long[] arr, int left, int mid, int right) {

        long[] temp = new long[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }
}