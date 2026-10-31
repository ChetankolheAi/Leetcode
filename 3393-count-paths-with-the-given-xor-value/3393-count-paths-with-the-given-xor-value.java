class Solution {
    int MOD = 1_000_000_007;
    public int Solve(int[][][] dp, int[][] grid , int i , int j , int k , int sum){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 ||i>=m || j>=n){
            return 0;
        }
        int newSum = sum^grid[i][j];
        if(i==m-1 && j==n-1 && k==newSum){
            return 1;
        }
        else if(i==m-1 && j==n-1){
            return 0;
        }
        if(dp[i][j][newSum]!=-1) return dp[i][j][newSum];

        int right = Solve(dp, grid, i, j + 1, k, newSum);
        int down  = Solve(dp, grid, i + 1, j, k, newSum);

        dp[i][j][newSum] = (right + down) % MOD;

        return dp[i][j][newSum];
                
    }
    public int countPathsWithXorValue(int[][] grid, int k) {
           int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][17];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int l=0;l<17;l++){
                    dp[i][j][l] = -1;
                }
            }
        }
        return Solve(dp,grid,0,0,k,0);
    }
}