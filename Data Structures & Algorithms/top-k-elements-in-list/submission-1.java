class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[n+1];
        for(int key : map.keySet()){
            int freq = map.get(key);

            if(buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;

        for(int i = n; i >= 0 && idx < k; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    ans[idx++] = num;

                    if(idx == k)
                        break;
                }
            }
        }

        return ans;
    }
}
