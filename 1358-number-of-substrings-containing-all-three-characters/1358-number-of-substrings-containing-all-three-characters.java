class Solution {
    public int numberOfSubstrings(String s) {
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;

        int cnt = 0;
        int l=0;
        for(int r =0; r<s.length();r++){
            char c = s.charAt(r);
            if(c=='a') cntA++;
            if(c=='b') cntB++;
            if(c=='c') cntC++;

            while(cntA > 0 && cntB > 0 && cntC >0  && l<=r){
                cnt+= s.length()-r;
                char d = s.charAt(l);
                if(d=='a') cntA--;
                if(d=='b') cntB--;
                if(d=='c') cntC--;
                l++;
            }
        }
        return cnt;
    }
}