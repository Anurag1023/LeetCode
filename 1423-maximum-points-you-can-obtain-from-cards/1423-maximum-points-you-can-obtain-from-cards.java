class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int r = 0; r < k; r++) {
            sum += cardPoints[r];
        }
        int max = sum;
        for (int r = 0; r < k; r++) {
            sum = sum - cardPoints[k - r -1] + cardPoints[(cardPoints.length - 1 - r)];
            max = Math.max(sum, max);
        }
        return max;
    }
}