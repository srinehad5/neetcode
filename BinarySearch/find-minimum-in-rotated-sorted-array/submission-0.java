class Solution {
    public int findMin(int[] arr) {
        
        int n = arr.length;
        int min = Integer.MAX_VALUE;

        int l = 0, h = n-1;
        while(l <= h){

            int mid = (l+h)/2;
            if(arr[l] <= arr[h]){
                min = Math.min(min, arr[l]);
                break;
            }
            else if(arr[l] <= arr[mid]){
                min = Math.min(min, arr[l]);
                l = mid+1;
            }
            else{
                min = Math.min(min, arr[mid]);
                h=mid-1;
            }
        }

        return min;
    }
}
