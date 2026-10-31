class Solution {
    public int MOD = 1_000_000_007;
    public int Solve(int[][][] dp , int[][] grid , int i , int j , boolean isRight)
    {
        int row = grid.length;
        int cols = grid[0].length;
        
        //Goes out of grid
        if(i<0 || j<0 || i>= row || j>=cols) return 0;

        //Reches the ending block
        if(i==row-1 && j==cols-1) return 1;
        
        int crrDigit = grid[i][j];
        
        //Calls when grid unit id empty ( i.e :- 0 );
        if(crrDigit==0){

            if(dp[i][j][0]==-1){
                dp[i][j][0] =  Solve(dp , grid , i  , j+1 , true);
            }
            if(dp[i][j][1]==-1){
                dp[i][j][1] =  Solve(dp , grid , i+1  , j , false);
            }
            return (int)(((long)dp[i][j][0] + dp[i][j][1]) % MOD);

        
        }//Calls when the entrance from DOWN and grid has mirror (i.e :- 1)
        else if(crrDigit == 1 && !isRight) {
            if(dp[i][j][0]!=-1) return dp[i][j][0];
            return dp[i][j][0] = Solve(dp,grid , i  , j+1 , true);
        }
        //Calls when the entrance from RIGHT and grid has mirror (i.e :- 1)
        else if(crrDigit == 1 && isRight){
            if(dp[i][j][1]!=-1) return dp[i][j][1];
            return dp[i][j][1] = Solve(dp,grid , i+1 , j , false);
        }
            
        return 0;
    }
    public int uniquePaths(int[][] grid) {
        int row = grid.length;
        int cols = grid[0].length;

        int dp[][][] = new int[row][cols][2];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return Solve(dp, grid , 0 , 0 , false );
    }
}