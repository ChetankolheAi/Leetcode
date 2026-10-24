class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int size = mat.length;
        for(int i=0;i<mat.length;i++){
            sum+=mat[i][i];
            if(i==size-i-1) continue;
            sum+=mat[i][size-1-i];
            
        }
       
        return sum;
    }
}