package _Heap_Sort;

import java.util.Arrays;

public class Solution {
  public void heapSort(int[] nums) {
    for (int i = nums.length / 2 - 1; i >= 0; i--) {
      heapify(nums, i, nums.length);
      System.out.println(Arrays.toString(nums));
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      swap(nums, 0, i);
      heapify(nums, 0, i);
    }
  }

  private void heapify(int[] nums, int i, int length) {
    int largest = i;
    int leftChild = 2 * i + 1;
    int rightChild = 2 * i + 2;
    if (leftChild < length && nums[leftChild] > nums[largest]) {
      largest = leftChild;
    }
    if (rightChild < length && nums[rightChild] > nums[largest]) {
      largest = rightChild;
    }
    if (largest != i) {
      swap(nums, i, largest);
      heapify(nums, largest, length);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
