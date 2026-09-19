class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int[] prefmax = new int[n];
        for(int i = 1; i < n; i++)
            prefmax[i] = Math.max(prefmax[i-1], height[i-1]);
        int[] suffmax = new int[n];
        for(int i = n-2; i >= 0; i--)
            suffmax[i] = Math.max(suffmax[i+1], height[i+1]);

        int ans = 0;
        for(int i = 1; i < n-1; i++){
            int l = prefmax[i];
            int r = suffmax[i];

            int h = Math.min(l, r) - height[i];
            if(h > 0)
                ans += h;
        }

        return ans;
    }
}
