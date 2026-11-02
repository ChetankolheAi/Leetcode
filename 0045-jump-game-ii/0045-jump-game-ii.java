class Solution {
    public int Solve(int[] dp ,int[] nums , int i){
        //Integer.MAX_VALUE means we can't reach the last position from that index
        if (i >= nums.length) return Integer.MAX_VALUE;
        if (i == nums.length - 1) return 0;
        if (dp[i] != -1) return dp[i];
        int MinCount = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++){
            int x = Solve(dp, nums, i + j);
            if (x != Integer.MAX_VALUE)
                MinCount = Math.min(MinCount, x + 1);

        } 

        return dp[i] = MinCount;
    }
     public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return Solve(dp,nums,0);
    }
}