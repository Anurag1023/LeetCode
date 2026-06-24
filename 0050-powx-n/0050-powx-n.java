class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n<0){
            N= N*-1;
            x = 1/x;
        }
        return power(x,N);
    }

    private double power(double x, double n){
        if(n==0) return 1;
        else if(n%2==0) return power(x*x,n/2);
        else return x*power(x*x, (n-1)/2);
    }
}