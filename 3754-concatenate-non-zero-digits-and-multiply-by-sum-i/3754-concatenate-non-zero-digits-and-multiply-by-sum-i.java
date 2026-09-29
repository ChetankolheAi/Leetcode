class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        int sum = 0;
        long firstRev = 0;
        while(n>0){
            int digit = n%10;
            n/=10;
            sum+=digit;
            if(digit!=0){
                firstRev = (firstRev*10)+digit;
            }
        }
        long Secondrev = 0;
        while(firstRev>0){
            long digit = firstRev%10;
            firstRev/=10;
            if(digit!=0){
                Secondrev = (Secondrev*10)+digit;
            }
        }
   
        return Secondrev*sum;
    }
}