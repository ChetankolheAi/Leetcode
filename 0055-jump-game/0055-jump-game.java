class Solution {
    public boolean Solve(int[] dp ,int[] nums , int i){
        if(i>=nums.length)return false;
        if(i==nums.length-1) return true;
        int maxJumpCount = nums[i];
        if(dp[i]!=-1){
            if(dp[i]==1)return true;
            else return false;
        }
        for(int j=1;j<=maxJumpCount;j++){
            if (Solve(dp,nums, i + j)) {
                dp[i] = 1;
                return true;
            }

        }
        dp[i] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return Solve(dp,nums,0);
    }
}