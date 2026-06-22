class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i< numRows;i++){
            List<Integer> arr = new ArrayList<>(i+1);
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) arr.add(1);
                else{
                    int val = ans.get(i-1).get(j) + ans.get(i-1).get(j-1);
                    arr.add(val);
                }
            }
            ans.add(arr);
        }

        return ans;
    }
}