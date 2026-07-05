class Solution {
    public int arrangeCoins(int n) {
        
        if(n == 1 || n == 2)
            return 1;

        int l = 0, h = n-1;
        int k = -1;
        while(l <= h){
            int mid = l+ (h-l)/2;

            long sum = (long) mid * (mid + 1) / 2;

            if(sum <= n){
                k = mid;
                l=mid+1;
            }
            else
                h=mid-1;
        }

        return k;
    }
}