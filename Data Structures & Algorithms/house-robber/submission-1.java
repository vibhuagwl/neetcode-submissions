class Solution {
    public int rob(int[] nums) {
        int []memo = new int[nums.length];
        return rob(nums,0, memo);
    }
    public int rob(int[] nums, int idx, int[] memo) {
        if (idx >= nums.length) {
            return 0;
        }
        if(memo[idx]!=0)
        {
            return memo[idx];
        }
        int take = nums[idx] + rob(nums, idx + 2, memo);
        int skip = rob(nums, idx + 1, memo);
        memo[idx] =  Math.max(take, skip);
        return memo[idx];
    }
}
