class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> hs = new HashSet<>();
        int sum=0;
        
        if(n==1) return 1;

        int skip=0;

        for(int i=1;i<=n+skip;i++){
            if(hs.contains(k-i)){
                skip++;
                continue;
            }
            sum+=i;
            hs.add(i);
        }

        return sum;
    }
}