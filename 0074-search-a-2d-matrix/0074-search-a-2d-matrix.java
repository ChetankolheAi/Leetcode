class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       
        int row = matrix.length;
        int cols = matrix[0].length;


        int start = 0;
        int end = matrix.length-1;
        
        while(start <= end){

            int mid = start+(end-start)/2;

            if(matrix[mid][0]>target){
                end = mid-1;
            }
            else if(matrix[mid][cols-1]<target){
                start = mid+1;
            }
            else{
                //System.out.println(mid);
                int startCol = 0;
                int endCol = cols-1;
                int rowNumber = mid;
                while(startCol <= endCol){

                    int mid1 =startCol+(endCol-startCol)/2;

                    if(matrix[rowNumber][mid1] < target) startCol = mid1+1;
                    else if(matrix[rowNumber][mid1] > target) endCol = mid1-1;
                    else return true;
        
                }
                return false;
            }
        }
        return false;
    }
}