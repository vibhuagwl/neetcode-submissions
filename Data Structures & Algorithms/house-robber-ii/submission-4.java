class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }
        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        int option1 = rob(nums, 0, n - 2, memo1);
        int option2 = rob(nums, 1, n - 1, memo2);
        return Math.max(option1, option2);
    }

    public int rob(int[] nums, int idx, int end, int memo[]) {
        if (idx > end) {
            return 0;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int take = nums[idx] + rob(nums, idx + 2, end, memo);
        int skip = rob(nums, idx + 1, end, memo);
        memo[idx] = Math.max(take, skip);
        return memo[idx];
    }
}
