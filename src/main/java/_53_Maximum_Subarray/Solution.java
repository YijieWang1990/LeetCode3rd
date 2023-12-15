package _53_Maximum_Subarray;

class Solution {
  public int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
    }
    int max = Integer.MIN_VALUE;
    for (int value : dp) {
      max = Math.max(max, value);
    }
    return max;
  }
}