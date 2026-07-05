class Solution {

    public boolean bs(int[] arr, int k){

        int l = 0, h = arr.length-1;
        while(l <= h){
            int mid = (l+h)/2;

            if(arr[mid] == k)
                return true;
            else if(arr[mid] < k)
                l=mid+1;
            else
                h=mid-1;
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0, h = n-1;
        int floor = -1;
        while(l <= h){

            int mid = (l+h)/2;
            if(matrix[mid][0] <= target){
                floor = mid;
                l=mid+1;
            }
            else
                h=mid-1;
        }

        if(floor == -1)
            return false;
        
        int row = floor;

        return bs(matrix[row], target);

    }
}
