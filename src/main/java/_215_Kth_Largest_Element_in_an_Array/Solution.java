package _215_Kth_Largest_Element_in_an_Array;

import java.util.Random;

class Solution {
  public int findKthLargest(int[] nums, int k) {
    return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
  }

  private int findKthLargest(int[] nums, int start, int end, int k) {
    while(true) {
      int mid = partition(nums, start, end);
      if (mid - start == k) {
        return nums[mid];
      } else if (mid - start < k) {
        k = k - (mid - start) - 1;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
  }
  private int partition(int[] nums, int start, int end) {
    int i = start;
    for (int j = start; j < end; j++) {
      if (nums[j] < nums[end]) {
        swap(nums, i, j);
        i++;
      }
    }
    swap(nums, i, end);
    return i;
  }
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
