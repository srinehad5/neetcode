class Solution {
    public int findJudge(int n, int[][] trust) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] t : trust){
            int u = t[0];
            int v = t[1];
            map.putIfAbsent(u, new ArrayList<>());
            map.get(u).add(v);
        }

        if(map.size() == n)
            return -1;

        Map<Integer, Integer> freq = new HashMap<>();
        for(List<Integer> list : map.values()){
            for(int num : list){
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        int cnt = 0;
        int node = -1;
        for(int key : freq.keySet()){
            if(map.containsKey(key))
                continue;
            int value = freq.get(key);
            if(value == n-1){
                cnt++;
                node = key;
            }
        }

        if(cnt > 1)
            return -1;
        return node;
    }
}