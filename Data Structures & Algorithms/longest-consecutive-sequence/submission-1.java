class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        int maxlen = 0;
        for(int num : nums){
            if(set.contains(num-1))
                continue;
            
            int len = 1;
            while(true){
                num++;
                if(set.contains(num))
                    len++;
                else
                    break;
            }
            maxlen = Math.max(maxlen, len);
        }

        return maxlen;
    }
}
