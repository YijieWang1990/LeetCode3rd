package _45_Jump_Game_II;

class Solution {
  public int jump(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int step = 0;
    int maxReach = 0;
    int end = 0;
    for (int i = 0; i < nums.length; i++) {
      maxReach = Math.max(maxReach, i + nums[i]);
      if (maxReach >= nums.length - 1) {
        return step + 1;
      }
      if (end == i) {
        end = maxReach;
        step++;
      }
    }
    return 0;
  }
}