package _123_Best_Time_to_Buy_and_Sell_Stock_III;

class Solution {
  public int maxProfit(int[] prices) {
    int k = 2;
    int countTimes = k + 1;
    int totalDays = prices.length + 1;
    int[][] dpBuy = new int[totalDays][countTimes];
    int[][] dpSell = new int[totalDays][countTimes];
    for (int i = 1; i < countTimes; i++) {
      dpBuy[1][i] = -prices[0];
    }
    for (int i = 2; i < totalDays; i++) {
      for (int j = 1; j < countTimes; j++) {
        dpBuy[i][j] = Math.max(dpBuy[i - 1][j], dpSell[i - 1][j - 1] - prices[i - 1]);
        dpSell[i][j] = Math.max(dpSell[i - 1][j], dpBuy[i][j] + prices[i - 1]);
      }
    }
    return dpSell[totalDays - 1][countTimes - 1];
  }
}
