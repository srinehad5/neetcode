class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] == '.')
                    continue;

                char ch = board[i][j];
                int row_offset = (i/3) * 3;
                int col_offset = (j/3) * 3;

                for(int k = 0; k < 9; k++){
                    if(k != i && board[k][j] == ch)
                        return false;
                    if(k != j && board[i][k] == ch)
                        return false;
                    int row = row_offset + (k/3);
                    int col = col_offset + (k%3);
                    if((row != i || col != j) && board[row][col] == ch)
                        return false;
                }
            }
        }

        return true;
    }
}
