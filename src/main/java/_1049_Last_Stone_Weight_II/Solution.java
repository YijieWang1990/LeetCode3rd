package _1049_Last_Stone_Weight_II;

import java.util.Arrays;

class Solution {
  public int lastStoneWeightII(int[] stones) {
    int sum = Arrays.stream(stones).sum();
    int target = sum / 2;
    int[] dp = new int[target + 1];
    for (int i = 0; i < stones.length; i++) {
      for (int j = target; j>=stones[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
      }
    }
    return sum - 2 * dp[target];
  }
}