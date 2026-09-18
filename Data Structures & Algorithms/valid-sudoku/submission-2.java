class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] grid = new HashSet[9];
        
        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grid[i] = new HashSet<>();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                if(board[i][j] == '.')
                    continue;

                char num = board[i][j];
                int grid_row = i/3;
                int grid_col = j/3;
                int box = grid_row * 3 + grid_col;

                if(rows[i].contains(num) || cols[j].contains(num) || grid[box].contains(num))
                    return false;

                rows[i].add(num);
                cols[j].add(num);
                grid[box].add(num);
            }
        }

        return true;
    }
}
