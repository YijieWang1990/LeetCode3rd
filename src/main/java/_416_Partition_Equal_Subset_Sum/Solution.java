package _416_Partition_Equal_Subset_Sum;

import java.util.Arrays;

class Solution {
  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum / 2;
    int[] dp = new int[target + 1];
    for (int num : nums) {
      for (int j = target; j >= num; j--) {
        dp[j] = Math.max(dp[j], dp[j - num] + num);
      }
      if (dp[target] == target) {
        return true;
      }
    }
    return dp[target] == target;
  }
}