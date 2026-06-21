class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt=0;
        for(int i=0;i<costs.length;i++){
            if(coins<costs[i]) return cnt;
            else{
                cnt++;
                coins -= costs[i];
            }
        }
        return cnt;
    }
}