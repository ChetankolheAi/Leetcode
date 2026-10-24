class Solution {
    public boolean isPrime(int num){
        if(num == 1) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {

        int MaxPrime = Integer.MIN_VALUE;
        int size = nums.length;

        for(int i=0;i<size;i++){

            if(isPrime(nums[i][i]))
                MaxPrime = Math.max(MaxPrime , nums[i][i]);
            if(isPrime(nums[i][size-i-1]))
                MaxPrime = Math.max(MaxPrime , nums[i][size-i-1]);
            
        }
        MaxPrime = MaxPrime==Integer.MIN_VALUE?0:MaxPrime;
        return MaxPrime;
    }
}