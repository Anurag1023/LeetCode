class Solution {
    public int minimumCost(int[] cost) {
        int sum = 0;
        int cnt = 0;
        Arrays.sort(cost);
        for(int i=cost.length-1;i>=0;i--){
            if(cnt==2){
                cnt=0;
                continue;
            }else{
                sum+=cost[i];
                cnt++;
            }
        }
        return sum;
    }
}