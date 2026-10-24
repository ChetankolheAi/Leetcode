class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for(int i=0;i<mat.length;i++){
            sum+=mat[i][i];
            System.out.println(mat[i][i]);
        }
        int cols = mat.length;
        for(int i=0;i<mat.length;i++){
            if(i==cols-i-1) continue;
            sum+=mat[i][cols-1-i];
            System.out.println(mat[i][cols-1-i]);
        }
        return sum;
    }
}