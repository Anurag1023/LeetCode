class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;

        int[] diff = new int[n];
        int total = 0;

        // Step 1: assume all go to mouse2
        for (int i = 0; i < n; i++) {
            total += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }

        // Step 2: sort diff descending
        Arrays.sort(diff);

        // Step 3: pick top k gains
        for (int i = n - 1; i >= n - k; i--) {
            total += diff[i];
        }

        return total;
    }
}