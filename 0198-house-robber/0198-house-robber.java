class Solution {
        public int Solve(int[] dp,int[] nums , int i , int currSum){
            if(i>=nums.length){
                return 0;
            }
            if(dp[i]!=-1) return dp[i];
            int sum = currSum+nums[i];
            int rob = nums[i]+Solve(dp,nums,i+2,sum);
            int skip = Solve(dp,nums,i+1,sum);
            return dp[i] = Math.max(rob,skip);
        }
        public int rob(int[] nums) {
            int dp[] = new int[nums.length];
            Arrays.fill(dp,-1);
            return Solve(dp,nums,0,0);
        }
}