class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int maxValue = nums[0];
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(nums[right], maxProd * nums[right]);
            minProd = Math.min(nums[right], minProd * nums[right]);
            maxValue = Math.max(maxValue, maxProd);
        }
        return maxValue;
    }
}
