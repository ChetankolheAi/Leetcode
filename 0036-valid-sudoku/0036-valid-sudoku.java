class Solution {
    char[][] board;
    public boolean isValid(int i , int j){
        //Check row
        boolean isValid1 = true;
        int num = board[i][j];
        for(int k=0;k<9;k++){
            if(board[i][k]==num && k!=j)isValid1 = false;
        }
        for(int k=0;k<9;k++){
            if(board[k][j]==num && k!=i)isValid1 = false;
        }
        int startRow  = (i/3)*3;
        int startCol = (j/3)*3;
        for(int r = startRow ; r < startRow+3;r++){
            for(int c = startCol ; c < startCol+3;c++){
                if(board[r][c] == num && r!=i && c!=j) isValid1 = false;
            }
        }
        return isValid1;
    }
    public boolean isValidSudoku(char[][] board1) {
        board = board1;
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !isValid(i,j))return false;
            }
        }
        return true;
    }
}