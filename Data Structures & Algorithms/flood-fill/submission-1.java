class Solution {

    class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void dfs(int[][] image, int sr, int sc, int oldcolor, int newcolor, int n, int m, int[] dr, int[] dc){

        image[sr][sc] = newcolor;

        for(int k = 0; k < 4; k++){
            int nr = sr + dr[k];
            int nc = sc + dc[k];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == oldcolor){
                dfs(image, nr, nc, oldcolor, newcolor, n, m, dr, dc);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color)
            return image;

        int oldcolor = image[sr][sc];

        int n = image.length;
        int m = image[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        dfs(image, sr, sc, oldcolor, color, n, m, dr, dc);

        return image;

    }
}