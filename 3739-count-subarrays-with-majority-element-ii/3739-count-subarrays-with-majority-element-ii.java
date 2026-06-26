class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == target) ? 1 : -1;
        }

        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        return mergeSort(prefix, 0, n);
    }

    private long mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;

        long cnt = 0;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);

        int i = low;
        for (int j = mid + 1; j <= high; j++) {
            while (i <= mid && arr[i] < arr[j]) {
                i++;
            }
            cnt += i - low;
        }

        merge(arr, low, mid, high);

        return cnt;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int idx = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[idx++] = arr[left++];
        }

        while (right <= high) {
            temp[idx++] = arr[right++];
        }

        for (int k = 0; k < temp.length; k++) {
            arr[low + k] = temp[k];
        }
    }
}