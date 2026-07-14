class Solution {

    class Node{
        int row, col, time;
        Node(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Node(i, j, 0));
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int maxtime = 0;

        while(!q.isEmpty()){
            Node node = q.poll();
            int r = node.row;
            int c = node.col;
            int t = node.time;

            maxtime = Math.max(maxtime, t);

            for(int k = 0; k < 4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    q.add(new Node(nr, nc, t+1));
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return maxtime;
    }
}
