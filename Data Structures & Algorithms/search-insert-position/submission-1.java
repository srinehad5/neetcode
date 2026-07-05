class Solution {
    public int searchInsert(int[] arr, int target) {
        
        int n = arr.length;
        int lb = n;
        int l = 0, h = n-1;

        while(l <= h){
            
            int mid = (l+h)/2;
            if(arr[mid] >= target){
                lb = mid;
                h=mid-1;
            }
            else
                l=mid+1;
        }

        return lb;
    }
}