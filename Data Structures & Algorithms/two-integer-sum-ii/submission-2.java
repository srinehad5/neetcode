class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int n = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int val = target - numbers[i];
            if(map.containsKey(val))
                return new int[]{map.get(val)+1, i+1};
            map.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }
}
