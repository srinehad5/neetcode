class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] cnt = new int[26];
            for(char ch : str.toCharArray())
                cnt[ch-'a']++;
            String key = Arrays.toString(cnt);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        List<List<String>> ans = new ArrayList<>();
        for(List<String> list : map.values())
            ans.add(list);

        return ans;
    }
}
