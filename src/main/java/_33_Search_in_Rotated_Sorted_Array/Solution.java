package _33_Search_in_Rotated_Sorted_Array;

class Solution {
  public int search(int[] nums, int target) {
    if (nums.length < 1) {
      return -1;
    }
    if (nums.length == 1) {
      return target == nums[0] ? 0 : -1;
    }
    int low = 0;
    int high = nums.length-1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[low] <= nums[mid]) {
        if (nums[low] <= target && target < nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }


}