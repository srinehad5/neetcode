class Solution {

    public void dfs(int r, int c, char[][] mat, boolean[][] vis, int n, int m, int[] dr, int[] dc){
        vis[r][c] = true;
        for(int k = 0; k < 4; k++){
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == 'O' && !vis[nr][nc])
                dfs(nr, nc, mat, vis, n, m, dr, dc);
        }
    }

    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < n; i++){
            if(!vis[i][0] && board[i][0] == 'O')
                dfs(i, 0, board, vis, n, m, dr, dc);
            if(!vis[i][m-1] && board[i][m-1] == 'O')
                dfs(i, m-1, board, vis, n, m, dr, dc);
        }
        for(int j = 0; j < m; j++){
            if(!vis[0][j] && board[0][j] == 'O')
                dfs(0, j, board, vis, n, m, dr, dc);
            if(!vis[n-1][j] && board[n-1][j] == 'O')
                dfs(n-1, j, board, vis, n, m, dr, dc);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !vis[i][j])
                    board[i][j]= 'X';
            }
        }

    }
}
