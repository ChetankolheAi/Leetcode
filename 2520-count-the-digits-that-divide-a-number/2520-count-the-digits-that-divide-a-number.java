class Solution {
    public int countDigits(int num) {
        int original = num;
        int count = 0;
        while(num>0){
            int digit = num%10;
            num/=10;
            count = (original%digit==0)?count+1:count; // count++ :) //looks good // 
        }
        return count;
    }
}