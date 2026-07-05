class Solution {

    public boolean check(int[] piles, int k, int h){

        int totalhrs = 0;
        for(int num : piles){
            totalhrs += Math.ceil((double)num/(double)k);
        }

        if(totalhrs <= h)
            return true;

        return false;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        
        int max = -1;
        for(int num : piles){
            max = Math.max(max, num);
        }

        int low = 1, high = max;
        while(low <= high){
            int mid = (low+high)/2;

            if(check(piles, mid, h))
                high=mid-1;
            else
                low=mid+1;
        }

        return low;
    }
}
