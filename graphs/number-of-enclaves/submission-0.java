class Solution {

    public void dfs(int r, int c, int[][] mat, boolean[][] vis, int[] dr, int[] dc, int n, int m){

        vis[r][c] = true;

        for(int k = 0; k < 4; k++){
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && mat[nr][nc] == 1)
                dfs(nr, nc, mat, vis, dr, dc, n, m);
        }
    }

    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < n; i++){
            if(!vis[i][0] && grid[i][0] == 1)
                dfs(i, 0, grid, vis, dr, dc, n, m);
            if(!vis[i][m-1] && grid[i][m-1] == 1)
                dfs(i, m-1, grid,vis, dr, dc, n, m);
        }
        for(int j = 0; j < m; j++){
            if(!vis[0][j] && grid[0][j] == 1)
                dfs(0, j, grid, vis, dr, dc, n, m);
            if(!vis[n-1][j] && grid[n-1][j] == 1)
                dfs(n-1, j, grid, vis, dr, dc, n, m);
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j])
                    cnt++;
            }
        }

        return cnt;
    }
}