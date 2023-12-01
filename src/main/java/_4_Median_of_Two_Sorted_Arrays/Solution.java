package _4_Median_of_Two_Sorted_Arrays;

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int size = nums1.length + nums2.length;
    if (size % 2 == 0) {
      return ((double)findKthNumber(nums1, nums2, size / 2) + (double)findKthNumber(nums1, nums2, size / 2 + 1)) / 2;
    }
    return findKthNumber(nums1, nums2, size / 2 + 1);
  }

  private int findKthNumber(int[] nums1, int[] nums2, int k) {
    int index1 = 0;
    int index2 = 0;
    int middle = k / 2;
    while (true) {
      if (index1 >= nums1.length) {
        return nums2[index2 + k - 1];
      }
      if (index2 >= nums2.length) {
        return nums1[index1 + k - 1];
      }
      if (k == 1) {
        return Math.min(nums1[index1], nums2[index2]);
      }
      int target1 = Math.min(index1 + middle, nums1.length) - 1;
      int target2 = Math.min(index2 + middle, nums2.length) - 1;
      int num1 = nums1[target1];
      int num2 = nums2[target2];
      if (num1 <= num2) {
        k -= (target1 - index1 + 1);
        index1 = target1 + 1;
      } else {
        k -= (target2 - index2 + 1);
        index2 = target2 + 1;
      }
      middle = k / 2;
    }
  }
}