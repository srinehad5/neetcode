class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            Set<Integer> s = new HashSet<>();
            for(int j = i+1; j < n; j++){
                int val = -(nums[i] + nums[j]);
                if(s.contains(val)){
                    List<Integer> list = Arrays.asList(nums[i], val, nums[j]);
                    Collections.sort(list);
                    set.add(list);
                }
                s.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }
}
