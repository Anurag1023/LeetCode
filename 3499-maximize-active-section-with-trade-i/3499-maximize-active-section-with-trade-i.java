class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int cnt1 = 0;
        int prev = 0;
        int max = 0;
        int n = s.length(), i = 0;


        while(i<n){
            if(s.charAt(i)== '1') {
                cnt1++;
                i++;
            }
            else{
                int curr = 0;
                while(i<n && s.charAt(i)=='0'){
                    curr++;
                    i++;
                }

                if(prev>0){
                    max = Math.max(max, prev + curr);
                }
                prev = curr;
            }
        }
        return cnt1 + max;
    }
}