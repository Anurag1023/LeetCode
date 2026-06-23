class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0] );

        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        int[] temp = {intervals[0][0],intervals[0][1]};

        for(int i=1;i<n;i++){
            if(temp[1]>=intervals[i][0]){
                temp[1] = Math.max(temp[1], intervals[i][1]);
            }else{
                ans.add(temp);
                temp = new int[]{intervals[i][0], intervals[i][1]};;
            }
        }

        ans.add(temp);

        return ans.toArray(new int[0][]);
    }
}