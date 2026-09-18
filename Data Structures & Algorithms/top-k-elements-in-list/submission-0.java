class Solution {

    class Pair{
        int val, freq;
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                return Integer.compare(a.freq, b.freq);
            }
        );

        for(int key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
            if(pq.size() > k)
                pq.poll();
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++)
            ans[i] = pq.poll().val;

        return ans;
    }
}
