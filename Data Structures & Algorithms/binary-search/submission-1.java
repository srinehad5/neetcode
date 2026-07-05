class Solution {

    public int f(int[] arr, int target, int l, int h){

        if(l > h)
            return -1;

        int mid = (l+h)/2;
        if(arr[mid] == target)
            return mid;
        else if(arr[mid] < target)
            return f(arr, target, mid+1, h);
        else
            return f(arr, target, l, mid-1);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        return f(nums, target, 0, n-1);
    }
}
