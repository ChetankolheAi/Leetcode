class Solution {
    char[][] board;
    public boolean isValid(int i, int j, char num) {

        // Check row
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == num && k != j)
                return false;
        }

        // Check column
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == num && k != i)
                return false;
        }

        // Check 3x3 grid
        int startRow = (i / 3) * 3;
        int startCol = (j / 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {

                if (board[r][c] == num && (r != i || c != j))
                    return false;
            }
        }

        return true;
    }
    public boolean Solve(int i , int j)
    {

        if (i == 9) return true;

        int nextRow = (j == 8) ? i + 1 : i;
        int nextCol = (j + 1) % 9;
        if (board[i][j] != '.') {
            return Solve(nextRow, nextCol);
        }

        for(int k=1;k<=9;k++)
        {
            if(isValid(i,j,(char)(k+'0')))
            {
                board[i][j] = (char)(k+'0');
                if (Solve(nextRow, nextCol))
                    return true;

                board[i][j] = '.';
            }
        }
        return false;
    }


    public void solveSudoku(char[][] boardd) {
        board = boardd;
        Solve(0, 0);

    }
}