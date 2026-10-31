class Solution {
    int MOD = 1_000_000_007;
    public int Solve(int[][][] dp ,int m , int n , int i , int j , int moves,int maxMove){

        if(maxMove >= moves && (i<0 || j<0 || i>=m || j>=n))return 1;
        else if(i<0 || j<0 || i>=m || j>=n ) return 0;

        //Checking is crrmove are greater then maxMoves
        if(moves>=maxMove) return 0;
        if(dp[i][j][moves]!=-1) return dp[i][j][moves];
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        
        int branchCount = 0;
        for(int k = 0; k < 4 ; k++){
            branchCount = (branchCount +  Solve(dp,m,n,i+dir[k][0],j+dir[k][1],moves+1,maxMove))%MOD;
        }
        return  dp[i][j][moves]= branchCount;
        // if(dp[i][j][0]==-1) dp[i][j][0] =  Solve(dp,m,n,i,j+1,moves+1,maxMove);
        // if(dp[i][j][1]==-1) dp[i][j][1] =  Solve(dp,m,n,i,j-1,moves+1,maxMove);
        // if(dp[i][j][2]==-1) dp[i][j][2] =  Solve(dp,m,n,i+1,j,moves+1,maxMove);
        // if(dp[i][j][3]==-1) dp[i][j][3] =  Solve(dp,m,n,i-1,j,moves+1,maxMove);

        // return dp[i][j][0]+dp[i][j][1]+dp[i][j][2]+dp[i][j][3]; 
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            int dp[][][]=new int[m][n][maxMove];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<maxMove;k++){
                        dp[i][j][k] = -1;
                    }
                }
            }
            return Solve(dp,m , n, startRow, startColumn ,0, maxMove);
    }
}