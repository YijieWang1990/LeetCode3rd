package _31_Next_Permutation;

class Solution {
  public void nextPermutation(int[] nums) {
    int index = nums.length - 1;
    while (index > 0) {
      if (nums[index - 1] < nums[index]) {
        break;
      }
      index--;
    }
    if (index == 0) {
      flap(nums, 0, nums.length - 1);
      return;
    }
    int target1 = index - 1;
    index = nums.length - 1;
    while (index > target1) {
      if (nums[index] > nums[target1]) {
        break;
      }
      index--;
    }
    int target2 = index;
    swap(nums, target1, target2);
    flap(nums, target1+1, nums.length-1);
  }

  private void flap(int[] nums, int start, int end) {
    while (start <= end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }

  private void swap(int[] nums, int start, int end) {
    int temp = nums[start];
    nums[start] = nums[end];
    nums[end] = temp;
  }
}
