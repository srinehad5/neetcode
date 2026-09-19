class Solution {
    public int maxArea(int[] heights) {
        
        int n = heights.length;
        int i = 0, j = n-1;
        int maxarea = 0;

        while(i < j){

            int h = Math.min(heights[i], heights[j]);
            int w = j-i;
            maxarea = Math.max(maxarea, h*w);

            if(heights[i] < heights[j])
                i++;
            else
                j--;
        }

        return maxarea;
    }
}
