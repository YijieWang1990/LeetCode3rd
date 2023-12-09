package _40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  private List<List<Integer>> result = new ArrayList<>();

  private List<Integer> ans = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    boolean[] visit = new boolean[candidates.length];
    backtrace(candidates, 0, target, 0, visit);
    return result;
  }

  private void backtrace(int[] candidates, int start, int target, int currentSum, boolean[] isVisit) {
    if (currentSum == target) {
      result.add(new ArrayList<>(ans));
      return;
    }
    if (start >= candidates.length) {
      return;
    }
    if (currentSum > target) {
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      if (i > 0 && candidates[i] == candidates[i - 1] && !isVisit[i-1]) {
        continue;
      }
      currentSum += candidates[i];
      ans.add(candidates[i]);
      isVisit[i] = true;
      backtrace(candidates, i + 1, target, currentSum, isVisit);
      ans.remove(ans.size() - 1);
      currentSum -= candidates[i];
      isVisit[i] = false;
    }

  }
}
