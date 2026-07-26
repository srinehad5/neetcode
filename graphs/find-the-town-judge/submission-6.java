class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] delta = new int[n+1];
        
        for(int[] t : trust){
            int u = t[0];
            int v = t[1];

            delta[v]++;
            delta[u]--;
        }

        for(int i = 1; i <= n; i++){
            if(delta[i] == n-1)
                return i;
        }

        return -1;
    }
}