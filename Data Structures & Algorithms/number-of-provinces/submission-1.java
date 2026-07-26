class Solution {

    public void dfs(int node, boolean[] vis, List<List<Integer>> adj){

        vis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i])
                dfs(i, vis, adj);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1)
                    adj.get(i).add(j);
            }
        }

        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                cnt++;
                dfs(i, vis, adj);
            }
        }

        return cnt;
    }
}