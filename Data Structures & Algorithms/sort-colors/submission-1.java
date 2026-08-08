class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = 0;
        int k = nums.length - 1;
        while (right <= k) {
            if (nums[right] == 0) {
               swap(nums, left, right);
                left++;
                right++;
            } else if (nums[right] == 2) {
                swap(nums, right, k);
                k--;
            } else {
               right++;
            }
        }
    }
    public void swap(int nums[], int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}