class Solution {
    public int countPrimeSetBits(int left, int right) {
        int primeCnt = 0;
        for(int i = left; i<=right;i++){
            int bitCnt = 0;
            int num = i;
            while(num!=0){
                if((num & 1)==1){
                    bitCnt++;
                }
                num>>=1;
            }
            if(check(bitCnt)) primeCnt++;
        }
        return primeCnt;
    }

    private boolean check(int num){
        if(num == 0 || num==1) return false;
        for(int i=2;i<=num/2;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}