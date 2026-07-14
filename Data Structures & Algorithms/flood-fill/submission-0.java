class Solution {

    class Pair{
        int row, col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color)
            return image;

        int oldcolor = image[sr][sc];

        int n = image.length;
        int m = image[0].length;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(sr,sc));
        image[sr][sc] = color;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == oldcolor){
                    image[nr][nc] = color;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        return image;

    }
}