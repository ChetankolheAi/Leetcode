class Solution {
        public int Solve(int[] dp,int[] nums , int i , int end )
        {
            if(i>end) return 0;

            //Checking if the state is Already Present in DP or not
            if(dp[i]!=-1) return dp[i];

            int rob = nums[i]+Solve(dp,nums,i+2 , end);
            int skip = Solve(dp,nums,i+1,end);

            return dp[i] = Math.max(rob,skip);
        }
        public int rob(int[] nums) 
        {
            if (nums.length == 1) return nums[0];
            int dp[] = new int[nums.length];
            int dp1[] = new int[nums.length];
            Arrays.fill(dp,-1);
            Arrays.fill(dp1,-1);
            return Math.max(Solve(dp,nums,0,nums.length-2),Solve(dp1,nums,1,nums.length-1));
        }
}