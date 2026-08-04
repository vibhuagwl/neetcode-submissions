class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftprod = new int[n];
        int[] rightprod = new int[n];
        int[] result = new int[n];
        leftprod[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftprod[i] = leftprod[i - 1] * nums[i];
        }
        rightprod[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightprod[i] = rightprod[i + 1] * nums[i];
        }
        result[0] = rightprod[1];
        result[n - 1] = leftprod[n - 2];
        for (int i = 1; i < n - 1; i++) {
            result[i] = leftprod[i - 1] * rightprod[i + 1];
        }
        return result;
    }
}