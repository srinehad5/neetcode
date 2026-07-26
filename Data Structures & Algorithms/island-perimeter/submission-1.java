class Solution {

    class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int dfs(int row, int col, int[][] grid, boolean[][] vis, int[] dr, int[] dc, int n, int m){
        
        if(!(row >= 0 && row < n && col >= 0 && col < m) || grid[row][col] == 0)
            return 1;
        if(vis[row][col])
            return 0;

        vis[row][col] = true;

        int cnt = 0;
        for(int k = 0; k < 4; k++){
            int nr = row + dr[k];
            int nc = col + dc[k];
            cnt += dfs(nr, nc, grid, vis, dr, dc, n, m);
        }

        return cnt;
    }

    public int islandPerimeter(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
;
        boolean flag = false;
        boolean[][] vis = new boolean[n][m];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return dfs(i, j, grid, vis, dr, dc, n, m);
                }
            }
        }

        return 0;
    }
}