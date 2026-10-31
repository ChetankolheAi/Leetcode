class Solution {
    public int Solve(int[][][] dp ,int m , int n , int i , int j){
        
        if(i<0 || j<0 || i>= m  || j>= n) return 0;
        
        if(i==m-1 && j==n-1) return 1;
    
        if(dp[i][j][0] == -1) dp[i][j][0] =  Solve(dp,m , n , i , j+1);
        if(dp[i][j][1] == -1) dp[i][j][1] =  Solve(dp,m , n , i+1 , j);
        
        return dp[i][j][0]+dp[i][j][1];
    }
    public int uniquePaths(int m, int n) {
        int dp[][][] = new int[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return Solve(dp,m,n,0,0);
    }
}