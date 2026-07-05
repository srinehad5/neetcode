class Solution {
    public int arrangeCoins(int n) {
        
        if(n == 1 || n == 2)
            return 1;

        int stairs = 0;
        int i = 1;
        while(n > 1){

            if(n >= i)
                n -= i;
            else
                break;
            stairs++;
            i++;
        }

        return stairs;
    }
}