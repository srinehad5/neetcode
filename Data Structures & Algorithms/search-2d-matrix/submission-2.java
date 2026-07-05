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

        for(int i = 0; i < n; i++){
            boolean flag = bs(matrix[i], target);
            if(flag)
                return true;
        }

        return false;

    }
}
