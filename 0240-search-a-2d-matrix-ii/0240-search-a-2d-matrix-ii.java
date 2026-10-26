class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int cols = matrix[0].length;

    //     for(int i=0;i<row;i++){
    //         int start = 0;
    //         int end = cols-1;
            
    //         while(start<=end){

    //             int mid = start+(end-start)/2;
                
    //             if(matrix[i][mid]==target) return true;
    //             else if(matrix[i][mid]<target) start = mid+1;
    //             else if(matrix[i][mid]>target) end = mid-1;
    //         }     
    //     }
    //     return false;

        int crrRow = 0;
        int crrCols = cols-1;
        while(crrRow < row && crrCols >= 0){
            if(matrix[crrRow][crrCols]==target) return true;
            else if(matrix[crrRow][crrCols]>target){
                crrCols--;
            }
            else if(matrix[crrRow][crrCols]<target){
                crrRow++;
            }
        }
        return false;
    }
}