class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int cnt = 0;
        Arrays.sort(piles);
        for(int i= n/3; i<n; i+=2){
            cnt+=piles[i];
        }
        return cnt;
    }
}