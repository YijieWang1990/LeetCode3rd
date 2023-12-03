package _15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 1; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int target = -(nums[i] + nums[j]);
        int k = nums.length - 1;
        while (k > j && nums[k] > target) {
          k--;
        }
        if (j == k) {
          break;
        }
        if (nums[k] == target) {
          result.add(List.of(nums[i], nums[j], nums[k]));
        }
      }
    }
    return result;
  }
}
