package _121_Best_Time_to_Buy_and_Sell_Stock;

class Solution {
  public int maxProfit(int[] prices) {
    int low = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      int currentProfit = prices[i] - low;
      maxProfit = Math.max(maxProfit, currentProfit);
      low = Math.min(low, prices[i]);
    }
    return maxProfit;
  }
}
