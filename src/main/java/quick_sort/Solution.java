package quick_sort;

public class Solution {


  public void quickSort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }
  private void quickSort(int[] nums, int start, int end) {
    if (start < end) {
      int mid = partition(nums, start, end);
      quickSort(nums, start, mid - 1);
      quickSort(nums, mid+1, end);
    }
  }

  private int partition(int[] nums, int start, int end) {
    int i = start;
    int j = start;
    for (int index = start; index < end; index++) {
      if (nums[j] < nums[end]) {
        swap(nums, i, j);
        i++;
      }
      j++;
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
