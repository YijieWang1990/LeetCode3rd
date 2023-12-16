package _300_Longest_Increasing_Subsequence;

class Solution {
  public int lengthOfLIS(int[] nums) {
    int[] tail = new int[nums.length];
    tail[0] = nums[0];
    int tailLength = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > tail[tailLength - 1]) {
        tail[tailLength] = nums[i];
        tailLength++;
      } else {
        tail[findInsertIndex(tail, tailLength, nums[i])] = nums[i];
      }
    }
    return tailLength;
  }

  private int findInsertIndex(int[] tail, int tailLength, int num) {
    int start = 0;
    int end = tailLength - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (tail[mid] < num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }
}