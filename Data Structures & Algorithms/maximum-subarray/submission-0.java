class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int maxSum = nums[0];
        for (int right = 1; right < nums.length; right++) {
            currentMax = Math.max(nums[right], currentMax + nums[right]);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }
}
