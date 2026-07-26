class Solution {

    class DisjointSet{

        int[] parent;
        int[] size;

        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findUPar(int node){
            if(node == parent[node])
                return node;

            return parent[node] = findUPar(parent[node]);
        }

        public void unionBySize(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            if(ulp_u == ulp_v)
                return;

            if(size[ulp_u] < size[ulp_v]){
                size[ulp_v] += size[ulp_u];
                parent[ulp_u] = ulp_v;
            }
            else{
                size[ulp_u] += size[ulp_v];
                parent[ulp_v] = ulp_u;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(ds.findUPar(i) == i)
                cnt++;
        }

        return cnt;
    }
}