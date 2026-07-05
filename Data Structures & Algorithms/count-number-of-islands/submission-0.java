class Solution {

    public void dfs(int r, int c, boolean[][] vis, char[][] grid, int n, int m, int[] dr, int[] dc){

        vis[r][c] = true;

        for(int k = 0; k < 4; k++){
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == '1'){
                dfs(nr, nc, vis, grid, n, m, dr, dc);
            }
        }
    }

    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        boolean[][] vis = new boolean[n][m];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i, j, vis, grid, n, m, dr, dc);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
