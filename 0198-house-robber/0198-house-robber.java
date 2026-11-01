class Solution {
        public int Solve(int[] dp,int[] nums , int i )
        {
            if(i>=nums.length) return 0;

            //Checking if the state is Already Present in DP or not
            if(dp[i]!=-1) return dp[i];

            int rob = nums[i]+Solve(dp,nums,i+2);
            int skip = Solve(dp,nums,i+1);

            return dp[i] = Math.max(rob,skip);
        }
        public int rob(int[] nums) 
        {
            int dp[] = new int[nums.length];
            Arrays.fill(dp,-1);
            return Solve(dp,nums,0);
        }
}