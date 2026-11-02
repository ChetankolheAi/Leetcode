class Solution {
    public double myPow(double x, int n) {
        // if(n==0) return 1;
        // boolean isNegative = false;
        // if(n<0){
        //     isNegative = true;
        //     n = n*-1;
        // }
        // double ans = x;
        // for(int i=1;i<n;i++){
        //     ans*=x;
        // }
        // if(isNegative) return 1/ans;
        // return ans;
        return Math.pow(x,n);
    }
}