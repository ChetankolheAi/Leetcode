class Solution {
    public boolean Solve(int[] dp ,int[] nums , int i){
        if (i >= nums.length) return false;
        if (i == nums.length - 1) return true;
        if (dp[i] != -1) return dp[i] == 1;

        for (int j = 1; j <= nums[i]; j++) if(Solve(dp, nums, i + j)) return (dp[i] = 1) == 1;

        dp[i] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return Solve(dp,nums,0);
    }
}