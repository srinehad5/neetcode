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

        for(int[] arr : matrix){
            if(arr[0] <= target && target <= arr[m-1]){
                if(bs(arr, target))
                    return true;
            }
        }

        return false;
    }
}
