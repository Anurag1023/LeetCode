class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cnt = 0;
        int avg = 0;
        int sum = 0;
        int l=0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        avg = sum/k;
        if(avg>=threshold) cnt++;
        for(int r=k;r<arr.length;r++){
            sum = sum - arr[l] + arr[r];
            avg = sum/k;
            if(avg>=threshold) cnt++;
            l++;
        }

        return cnt;
    }
}