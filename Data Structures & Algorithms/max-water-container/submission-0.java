class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int maxWater = 0;
        int right = heights.length - 1;
        while (left <= right) {
            if (heights[left] <= heights[right]) {
                int water = heights[left];
                int distance = right - left;
                int totalWater = water * distance;
                maxWater = Math.max(maxWater, totalWater);
                left++;
            } else {
                int water = heights[right];
                int distance = right-left;
                int totalWater = water * distance;
                maxWater = Math.max(maxWater, totalWater);
                right--;
            }
        }
        return maxWater;
    }
}
