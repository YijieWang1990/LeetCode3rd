package _39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

class Solution {

  private List<List<Integer>> result = new ArrayList<>();

  private List<Integer> ans = new ArrayList<>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    backtrace(candidates, 0, target, 0);
    return result;
  }

  private void backtrace(int[] candidates, int start, int target, int currentSum) {
    if (start >= candidates.length) {
      return;
    }
    if (currentSum == target) {
      result.add(new ArrayList<>(ans));
      return;
    }
    if (currentSum > target) {
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      currentSum += candidates[i];
      ans.add(candidates[i]);
      backtrace(candidates, i, target, currentSum);
      ans.remove(ans.size() - 1);
      currentSum -= candidates[i];
    }

  }
}