class Solution {
    public long DFS(int[][] grid , int i , int j){
        int row = grid.length;
        int cols = grid[0].length;
        long sum = grid[i][j];
        grid[i][j] = 0;
        int directions[][] ={{0,-1},{0,1},{1,0},{-1,0}};
        for(int k=0;k<4;k++){
            int newI = i+directions[k][0];
            int newJ = j+directions[k][1];
            if(newI>=0 && newI<row && newJ >= 0 && newJ < cols && grid[newI][newJ]>0){
                sum+=DFS(grid , newI , newJ);
            }
        } 
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int row = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]>0){
                    long sum = DFS(grid , i , j);
                    if(sum%k==0) count++;
                }
            }
        }
        return count;
    }
}