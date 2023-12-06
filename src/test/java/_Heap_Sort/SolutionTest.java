package _Heap_Sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void name() {
    Solution solution = new Solution();
    int[] arr = {9, 5, 6, 3, 5, 3, 1, 0, 96, 66};
    solution.heapSort(arr);
    for (int j : arr) {
      System.out.println(j);
    }
  }
}