class Solution {
    public int Solve(int[][] grid , int i , int j , int xOrSum , int minSum , int row , int cols , int dp[][][]){
        if(i<0 || j<0 || i>=row || j>=cols){
            return Integer.MAX_VALUE;
        }
        int newxOR = xOrSum ^ grid[i][j];
        if(i==row-1 && j==cols-1){

            return newxOR;
        }
        if(dp[i][j][newxOR] != -1){
            return dp[i][j][newxOR];
        }
        int right = Solve(grid , i , j+1 , newxOR , minSum , row , cols , dp);
        int down = Solve(grid , i+1 , j , newxOR , minSum , row , cols , dp);
        return dp[i][j][newxOR] = Math.min(right,down);
    }
    public int minCost(int[][] grid) {
        int dp[][][] = new int[grid.length][grid[0].length][1024];
        for(int[][] a :dp){
            for(int[] b : a){
                Arrays.fill(b,-1);
            }
        }
        return Solve(grid , 0 , 0, 0 , 0  , grid.length , grid[0].length , dp);
    }
}