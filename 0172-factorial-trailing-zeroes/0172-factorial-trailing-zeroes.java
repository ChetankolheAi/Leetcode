class Solution {
    public int trailingZeroes(int n) {
        int num = n;
        int count = 0;
        while(num>0){
            int cnt = num/5;
            count+=cnt;
            num /= 5;
        }
        return count;
    }
}