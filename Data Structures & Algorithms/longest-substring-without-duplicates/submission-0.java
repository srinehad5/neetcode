class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int maxlen = 0;
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r < n){
            char ch = s.charAt(r);
            if(map.containsKey(ch) && map.get(ch) >= l){
                l = map.get(ch)+1;
            }
            map.put(ch, r);
            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }

        return maxlen;
    }
}
