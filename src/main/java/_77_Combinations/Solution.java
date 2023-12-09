package _77_Combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
  private List<List<Integer>> result = new ArrayList<>();

  private List<Integer> ans = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }

    backTrace(nums, 0, k);
    return result;
  }

  private void backTrace(int[] nums, int start, int k) {
    if (ans.size() == k) {
      result.add(new ArrayList<>(ans));
      return;
    }
    if (start >= nums.length) {
      return;
    }
    for (int i = start; i < nums.length ; i++) {
      ans.add(nums[i]);
      backTrace(nums, i + 1, k);
      ans.remove(ans.size() - 1);
    }
  }
}
