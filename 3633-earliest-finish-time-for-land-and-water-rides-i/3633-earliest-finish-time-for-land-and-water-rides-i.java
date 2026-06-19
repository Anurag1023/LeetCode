class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;
        
        int min = Integer.MAX_VALUE;

        int finish = landStartTime[0] + landDuration[0];

        for(int j=0;j<n;j++){
            finish = landStartTime[j] + landDuration[j];
            for(int i=0;i<m;i++){
                if(waterStartTime[i]<=finish){
                    min = Math.min(min,finish + waterDuration[i]);
                }else{
                    min = Math.min(min,waterStartTime[i] + waterDuration[i]);
                }
            }
        }

        for(int j=0;j<m;j++){
            finish = waterStartTime[j] + waterDuration[j];
            for(int i=0;i<n;i++){
                if(landStartTime[i]<=finish){
                    min = Math.min(min,finish + landDuration[i]);
                }else{
                    min = Math.min(min,landStartTime[i] + landDuration[i]);
                }
            }
        }

        return min;
    }
}