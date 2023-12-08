package _440_K_th_Smallest_in_Lexicographical_Order;

class Solution {
  public int findKthNumber(int n, int k) {
    int current = 1;
    k--;
    while (k > 0) {
      int childrenCount = getChildrenCount(current, n);
      if (childrenCount < k) {
        k -= childrenCount;
        current++;
      } else {
        current = current * 10;
        k--;
      }
    }
    return current;
  }

  private int getChildrenCount(int current, int n) {
    int count = 0;
    int left = current;
    int right = current;
    while (left <= n) {
      count += Math.min(right, n) - left + 1;
      left = left * 10;
      right = right * 10 + 9;
    }
    return count;
  }
}
