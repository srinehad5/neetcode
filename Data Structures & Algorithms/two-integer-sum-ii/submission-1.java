class Solution {

    public int bs(int[] arr, int start, int end, int val){

        int l= start, h = end;
        while(l <= h){
            int mid = (l+h)/2;
            if(arr[mid] == val)
                return mid;
            else if(arr[mid] < val)
                l=mid+1;
            else
                h=mid-1;
        }

        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        
        int n = numbers.length;
        for(int i = 0; i < n; i++){
            int val = target - numbers[i];
            int idx = bs(numbers, i+1, n-1, val);

            if(idx != -1)
                return new int[]{i+1, idx+1};
        }

        return new int[]{-1, -1};
    }
}
