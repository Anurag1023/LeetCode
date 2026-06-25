class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;

        int[] arr = new int[256];

        int l = 0;
        for (int r = 0; r < n; r++) {

            while (l < r && arr[s.charAt(r)] != 0) {
                arr[s.charAt(l)]--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            arr[s.charAt(r)]++;

        }

        return max;
    }
}