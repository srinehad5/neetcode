class Solution {

    class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int islandPerimeter(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        Queue<Pair> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1)
                    q.add(new Pair(i, j));
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(!(nr >= 0 && nr < n && nc >= 0 && nc < m) || grid[nr][nc] == 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}