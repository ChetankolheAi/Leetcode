class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;

        long N = n;
        boolean isNegative = N < 0;

        if (isNegative) N = -N;

        double ans = 1;

        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
            }

            x *= x;
            N /= 2;
        }

        return isNegative ? 1 / ans : ans;
    }
}